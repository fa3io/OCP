package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TesteSavePoint {

	public static void main(String[] args) {
		Connection connectionMySQL = null;
		Savepoint savePoint = null;
		try {
			connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost/ocp?user=root&password=admin");
			connectionMySQL.setAutoCommit(false);

			System.out.println("----------Efetuando INSERT 1 ----------");
			Statement statement = connectionMySQL.createStatement();
			String nome = "Risoka";
			String idade = "25";
			String sql_insert = "INSERT INTO estudante(NOME, IDADE) VALUES ('" + nome + "', '" + idade + "');";
			int linhasAfetadas = statement.executeUpdate(sql_insert);
			System.out.println("Linhas Afetadas: " + linhasAfetadas);

			savePoint = connectionMySQL.setSavepoint("SavePoint");
			System.out.println("----------Efetuando INSERT 2 ----------");

			nome = "Kilua";
			idade = "16";
			sql_insert = "INSERTE INTO estudante(NOME, IDADE) VALUES ('" + nome + "', '" + idade + "');";
			linhasAfetadas = statement.executeUpdate(sql_insert);
			System.out.println("Linhas Afetadas: " + linhasAfetadas);

		} catch (SQLException e) {
			try {
				connectionMySQL.rollback(savePoint);
				connectionMySQL.commit();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			}
		}

	}

}
