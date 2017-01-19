package br.com.tryexceptionassert;

public class UsandoAssert {

	public static void main(String[] args) {
		
		
		/**
		 * Sintaxe de uma asserção
		 * 
		 * assert <expressao booleana> : <qualquer outra expressao>
		 * 
		 * 1º Parametro deve ser uma expressao booleana
		 * 2º Parametro deve ser qualquer outro Objeto pode ser primitivo tabem
		 * 
		 * Para habilitar o uso dos asserts usamos os seguintes comandos:
		 * 
		 * java -ea MinhaClasse
		 * 			or
		 * java -enableassertions MinhaClasse
		 * 
		 * 
		 * Para Habilitar as assercoes no Eclipse podemos ir no menu Run -> Run Configuration ... -> Java Application  -> em VM arguments digitamos -ea
		 */
		
		try{
			usandoAssercao(10);			
		}catch(AssertionError assertionError){
			System.out.println("Assert Falhou: " + assertionError.getMessage());
			assertionError.printStackTrace();
		}
		
	}
	
	
	public static void usandoAssercao(Integer numero){
		System.out.println("Aprendendo Asserts");
		
		//Quando um assert falha é lançado um AssertionError
		assert numero > 9 : "Condicao Falhou!"; 
		
		assert numero == 9 : null;
		
	}
	
	
}
