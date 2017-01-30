package br.com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteJDBCSelect {

	public static void main(String[] args) {

		try {
			
			Connection connectionMySQL = Conexao.obterConexao(TipoConexao.UMA_STRING_UM_PROPERTIE);
				
			System.out.println("-------Imprimindo MetaDados do Banco--------");
			
			//Dados do Database
			DatabaseMetaData databaseMetaData = connectionMySQL.getMetaData();
			
			String numericFunctions = databaseMetaData.getNumericFunctions();
			boolean suportReseultSetScroll = databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			int maiorVersaoJDBC = databaseMetaData.getJDBCMajorVersion();
			
			System.out.println("Fun��es do Banco: " + numericFunctions);
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
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage() +"\nCodigo De Erro: "+e.getErrorCode()+"\nEstado: "+ e.getSQLState());
		}

	}

}
