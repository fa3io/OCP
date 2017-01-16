package br.com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TesteJDBCInsert {

	public static void main(String[] args) throws SQLException {

		Statement statement = null;
		PreparedStatement preparedStatement = null;
		Connection connectionMySQL = null;
		try {


			Properties propriedades = new Properties();

			propriedades.setProperty("user", "root");
			propriedades.setProperty("password", "admin");

			connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp", propriedades);

			connectionMySQL.setAutoCommit(false);
			
			System.out.println("----------Efetuando INSERT com Statement----------");
			statement = connectionMySQL.createStatement();
			String nome = "Luiz";
			String idade = "49";
			String sql_insert = "INSERT INTO estudante(NOME, IDADE) VALUES ('" + nome + "', '" + idade + "');";
			int linhasAfetadas = statement.executeUpdate(sql_insert);
			System.out.println("Linhas Afetadas: "+ linhasAfetadas);
			
			
			nome = "Beatriz";
			idade = "12";
			System.out.println("----------Efetuando INSERT com PreparedStatement----------");
			String sql_insert2 = "INSERT INTO estudante(NOME, IDADE) VALUES (?, ?)";
			preparedStatement = connectionMySQL.prepareStatement(sql_insert2);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, idade);
			
			 linhasAfetadas = preparedStatement.executeUpdate();
//			 System.out.println("Linhas Afetadas: "+ linhasAfetadas);
			 
			 
			 System.out.println("----------Efetuando INSERT com callableStatement (PROCEDURE)----------");
			 CallableStatement callableStatement = connectionMySQL.prepareCall("{call <PROCEDURE>(<PARAMETROS ?>)}");
			 callableStatement.setInt(1, 1000);
			 linhasAfetadas = callableStatement.executeUpdate();
			 System.out.println("Linhas Afetadas: "+ linhasAfetadas);
			 
			 
		} catch (SQLException e) {
			connectionMySQL.rollback();
			System.out.println("Erro: " + e.getMessage() + "\nCodigo De Erro: " + e.getErrorCode() + "\nEstado: " + e.getSQLState());
		}finally {
			connectionMySQL.commit();
			statement.close();
			preparedStatement.close();
		}

	}

}
