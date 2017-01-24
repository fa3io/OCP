package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static void main(String[] args) {
		Connection connectionMySQL;
		//Connection connectionHSQL;
		//Connection connectionSQLServer;
		
		
		try {
			connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp", "root", "admin");
			//connectionHSQL = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ocp", "SA", "");
			//connectionSQLServer = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ocp;user=root;password=admin;");
			
			System.out.println("Conexao efetuada com sucesso!!");
			
			connectionMySQL.close();
			//connectionHSQL.close();
			//connectionSQLServer.close();
		} catch (SQLException e) {
			System.out.println("Erro ao connectar: " + e.getMessage());
		}
	}
	
	// java -cp hsqldb.jar org.hsqldb.server.Server --dbname.0 ocp --database.0 file:ocp
	// java -cp hsqldb.jar org.hsqldb.util.DatabaseManager
}
