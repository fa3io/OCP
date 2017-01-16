package br.com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mysql.jdbc.Driver;

public class TesteJDBCSelect {

	public static void main(String[] args) {

		try {

			Connection connectionMySQL;

			Properties propriedades = new Properties();

			propriedades.setProperty("user", "root");
			propriedades.setProperty("password", "admin");

			// Temos 3 jeitos de fornecer uma conexão 1 String, 3 Strings, 1 String + 1 Properties(user,password)

			// connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp?user=root&password=admin");
			// connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp", "root", "admin");
			connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp", propriedades);

			System.out.println("Conexão efetuada com sucesso!!");
			
			
			System.out.println("-------Imprimindo MetaDados do Banco--------");
			//Dados do Database
			DatabaseMetaData databaseMetaData = connectionMySQL.getMetaData();
			
			String numericFunctions = databaseMetaData.getNumericFunctions();
			boolean suportReseultSetScroll = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			int maiorVersaoJDBC = databaseMetaData.getJDBCMajorVersion();
			
			System.out.println("Funções do Banco: " + numericFunctions);
			System.out.println("Maior Versao JDBC: " + maiorVersaoJDBC );
			System.out.println("Suporte a ResultSet Scrool: " + suportReseultSetScroll );
			

			
			Statement statement = connectionMySQL.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ESTUDANTE");
			
			// ResultSetMetaData conseguimos extrair metaDados de nossas consultas
			ResultSetMetaData resultSetMetadata = resultSet.getMetaData();

			System.out.println("-------Imprimindo MetaData--------");

			int numeroColunas = resultSetMetadata.getColumnCount();

			String coluna1 = resultSetMetadata.getColumnLabel(1);
			String coluna2 = resultSetMetadata.getColumnLabel(2);
			String coluna3 = resultSetMetadata.getColumnLabel(3);

			String nomeTabela = resultSetMetadata.getTableName(1);

			System.out.println("Numero de colunas: " + numeroColunas);
			System.out.println("Colunas: " + coluna1 + "; " + coluna2 + "; " + coluna3);
			System.out.println("Nome Tabela: " + nomeTabela);

			System.out.println("-------Imprimindo Registros--------");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " - ");
				System.out.print(resultSet.getString(2) + " - ");
				System.out.println(resultSet.getString(3));
			}

			// Classes Impementadas pelo Driver do banco escolhido
			Driver mySqlDriver;
			com.mysql.jdbc.Connection mySqlConnection;
			com.mysql.jdbc.Statement mySqlStatement;

			
			
			System.out.println("------- Trabalhando com RowSetFactory/CachedRowSet --------");
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			
			CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
			
			//Tipos de RowSets existentes
			rowSetFactory.createJdbcRowSet();//JdbcRowSet é uma implementação de Rowset conectada
			rowSetFactory.createCachedRowSet();//CachedRowSet  é apenas um Rowset desconectado .
			rowSetFactory.createWebRowSet();//WebRowSet é uma subclasse de CachedRowSet que sabe como transformar seus resultados em XML e retornar.
			rowSetFactory.createFilteredRowSet();//FilteredRowSet
			rowSetFactory.createJoinRowSet();//JoinRowSet é um WebRowSet que também sabe como formar o equivalente a um SQL JOIN sem ter que se conectar novamente ao banco de dados.
			
			
			cachedRowSet.setCommand("SELECT ID, NOME, IDADE FROM ESTUDANTE");
			cachedRowSet.execute(connectionMySQL);
			
			
			 while (cachedRowSet.next()) {
			      System.out.println(cachedRowSet.getInt("ID") + " - "+ cachedRowSet.getString("NOME") + " - "+cachedRowSet.getString("IDADE") );
			 }

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage() +"\nCodigo De Erro: "+e.getErrorCode()+"\nEstado: "+ e.getSQLState());
		}

	}

}
