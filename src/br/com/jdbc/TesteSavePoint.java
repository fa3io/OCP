package br.com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;



/**
 * Save point podem ser usados para recuperar-mos parte de uma transa��o  ou usar o roolback para voltar para uma ponto da transacao em especifico
 * Temos obrigatoriamente  de settar o autocommit para false, pois se ele for true teremos um erro em runtime ele n�o encontrar� o save pont
 * @author F�bio
 *
 */
public class TesteSavePoint {

	public static void main(String[] args) {
		Connection connectionMySQL = null;
		Savepoint savePoint = null;
		try {
			connectionMySQL = Conexao.obterConexao(TipoConexao.UMA_STRING_UM_PROPERTIE);
			connectionMySQL.setAutoCommit(false);//Desabilitando o autoCommit podemos ter varias instrucoes em uma trnsacao

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
			sql_insert = "INSERTE INTO estudante(NOME, IDADE) VALUES ('" + nome + "', '" + idade + "');"; // Inserindo erro de sintaxe para usar savepoint
			linhasAfetadas = statement.executeUpdate(sql_insert);
			System.out.println("Linhas Afetadas: " + linhasAfetadas);
			
			throw new SQLException(); 

		} catch (SQLException e) {
			try {
				connectionMySQL.rollback(savePoint);// voltando ao ponto ante de erro e commitando transacao
				connectionMySQL.commit();
			} catch (SQLException e1) {
				System.out.println(e.getMessage()); // Podemos receber um erro se o autoCommit nao for desabiitado
				System.out.println(e.getCause());
			}
		}

	}

}
