package br.com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLXML;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.sun.rowset.JdbcRowSetImpl;


/**
 * Com o Rowstes fazemos as coisas de maneira mais Java beans usando metodos get e set
 * 
 * Existem dois tipos de RowSet:
 * 
 * + RowSet conectado: A conexão com a fonte de dados é mantida por todo ciclo de vida do RowSet
 * + RowSet desconectado: A conexão pode ser fechado durante o ciclo de vida, 
 * 							mas para recuperar ou atualizar dados é necessário restabelecer a conexão.
 */
public class RowSets {

	public static void main(String[] args) {
		
		try(Connection connectionMySQL = Conexao.obterConexão(TipoConexao.UMA_STRING_UM_PROPERTIE);){
			
			System.out.println("------- Trabalhando com RowSetFactory/CachedRowSet --------");
			
			/**Possui duas formas de criar a fabrica de rowset */
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			//RowSetProvider.newFactory("factoryClassName", ClassLoader);
			
			/**Podemos criar um JdbcRowSet de 4 formas*/
			//JdbcRowSet jdbcRow = new JdbcRowSetImpl(); //Contrutor Padrao
			//JdbcRowSet jdbcRow = new JdbcRowSetImpl(<Conection>); // Passando uma conexao
			//JdbcRowSet jdbcRow = new JdbcRowSetImpl(<ResultSet>); // Passando uma ResultSet que deve ser de rolagem
			//jdbcRowSet = rowSetFactory.createJdbcRowSet(); // usando uma factory
		
			/**
			 * Tipos de RowSets existentes
			 */
			
			//JdbcRowSet é uma implementação de Rowset conectada necessario conexao para utilizar
			JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
			
			//CachedRowSet  é apenas um Rowset desconectado.
			CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
			
			//WebRowSet é um CachedRowSet que sabe como transformar seus resultados em XML e retornar, extends CachedRowSet
			WebRowSet webRowSet = rowSetFactory.createWebRowSet();
			
			//FilteredRowSet eh um WebRowSet dados podem ser filtrados. É necessário implementar a inteface Predicate com o método evaluate que 
			FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
			
			//JoinRowSet eh um WebRowSet que também sabe como formar o equivalente a um SQL JOIN sem ter que se conectar novamente ao banco de dados.
			JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
			
			
			cachedRowSet.setCommand("SELECT ID, NOME, IDADE FROM ESTUDANTE");
			cachedRowSet.execute(connectionMySQL);
			
			
			 while (cachedRowSet.next()) {
			      //System.out.println(cachedRowSet.getInt("ID") + " - "+ cachedRowSet.getString("NOME") + " - "+cachedRowSet.getString("IDADE") );
			      SQLXML sqlxml = cachedRowSet.getSQLXML("ID");
			 }
		}catch (SQLException e) {
			
		}

	}

}
