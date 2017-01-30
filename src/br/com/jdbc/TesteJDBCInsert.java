package br.com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Classe Mostrando os diferentes tipos de uso de instru��es em banco de dados 
 * 
 * @author Fabio Santos Alves
 *
 */
public class TesteJDBCInsert {

	public static void main(String[] args) throws SQLException {

		Statement statement = null;
		PreparedStatement preparedStatement = null;
		Connection connectionMySQL = null;
		try {

			connectionMySQL = Conexao.obterConexao(TipoConexao.TRES_STRINGS);

			connectionMySQL.setAutoCommit(false);
			
			System.out.println("----------Efetuando INSERT com Statement----------");
			statement = connectionMySQL.createStatement();
			String nome = "Luiz";
			String idade = "49";
			String sql_insert = "INSERT INTO estudante(NOME, IDADE) VALUES ('" + nome + "', '" + idade + "');"; //Alta possibilidade de SQLInject X: 
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
			 System.out.println("Linhas Afetadas: "+ linhasAfetadas);
			 
			 
			 System.out.println("----------Efetuando INSERT com callableStatement (PROCEDURE)----------");
			 CallableStatement callableStatement = connectionMySQL.prepareCall("{call INSERE_ALUNO(?,?)}");
			 callableStatement.setString(1, "Lahis De Sene");
			 callableStatement.setInt(2, 27);
			 linhasAfetadas = callableStatement.executeUpdate();
			 System.out.println("Linhas Afetadas: "+ linhasAfetadas);
			 
			 
		} catch (SQLException e) {
			connectionMySQL.rollback();
			System.out.println("Erro: " + e.getMessage() + "\nCodigo De Erro: " + e.getErrorCode() + "\nEstado: " + e.getSQLState());
		}finally {
			connectionMySQL.commit(); //Usamos este comando apenas quando desablitamos o autoComit -> connectionMySQL.setAutoCommit(false);
			statement.close();
			preparedStatement.close();
		}

	}

}
