package br.com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

enum TipoConexao{
	UMA_STRING,TRES_STRINGS,UMA_STRING_UM_PROPERTIE;
}

public class Conexao {
	
	/**
	 * Interfaces a seguir sao implementadas por cada Driver de banco exemplo MySql, Oracle, JavaDB, SQLServer
	 */
	Driver driver;
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	
	
	
	
	public static void main(String[] args) {
		Connection connectionMySQL;
		//Connection connectionHSQL;
	
		
		try {
			connectionMySQL =  obterConexao(TipoConexao.UMA_STRING_UM_PROPERTIE);
			
			
			System.out.println("Conexao efetuada com sucesso!!");
			
			connectionMySQL.close();
			//connectionHSQL.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao connectar: " + e.getMessage());
		}
	}

	/**
	 * Existem 3 maneiras de conseguir uma conex�o com o metodo getConnection da Classe DriverManager
	 * S�o exemplificados abaixo
	 * 
	 * @param tipo
	 * @return
	 * @throws SQLException
	 */
	public  static Connection obterConexao(TipoConexao tipo) throws SQLException {
		Connection connection = null;
		Properties propriedades = new Properties();
		propriedades.setProperty("user", "root");
		propriedades.setProperty("password", "admin");
		
		switch (tipo) {
		case UMA_STRING:
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ocp?user=root&password=admin");
			break;
		case TRES_STRINGS:
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ocp", "root", "admin");
			break;
		case UMA_STRING_UM_PROPERTIE:
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ocp", propriedades);
			break;
		}
		return connection;
	}
	
	//Comando para manipular banco de dados hsqldb
	// java -cp hsqldb.jar org.hsqldb.server.Server --dbname.0 ocp --database.0 file:ocp
	// java -cp hsqldb.jar org.hsqldb.util.DatabaseManager
}







































