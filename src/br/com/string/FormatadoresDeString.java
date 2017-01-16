package br.com.string;

public class FormatadoresDeString {

	public static void main(String[] args) {
		
		/* CARACTERES DE ESCAPE
		\n	Nova linha. Posiciona o cursor de tela no in�cio da pr�xima linha
		\t	Tabula��o horizontal. Move o cursor de tela para a pr�xima parada de tabula��o.
		\r	Posiciona o cursor da tela no in�cio da linha atual - n�o avan�a para a pr�xima linha. Qualquer sa�da de caracteres gerada depois de algum retorno j� gerado � sobrescrito os caracteres anteriores gerados na linha atual.
		\\	Barras invertidas. Utilizada para imprimir um caractere de barra invertida.
		\�	Aspas duplas. Utilizada para imprimir um caractere de aspas duplas. Exemplo, System.out.println(�\�aspas\��); exibe �aspas�
		 */
		
		/*
		 CONVERSORES
		 
		 d	 	    A decimal integer.
		 f	 	    A float.
		 n	 	    A new line character appropriate to the platform running the application. You should always use %n, rather than \n.
		 tB	 	    A date & time conversion�locale-specific full name of month.
		 td, te	 	A date & time conversion�2-digit day of month. td has leading zeroes as needed, te does not.
		 ty, tY	 	A date & time conversion�ty = 2-digit year, tY = 4-digit year.
		 tl	 	    A date & time conversion�hour in 12-hour clock.
		 tM	 	    A date & time conversion�minutes in 2 digits, with leading zeroes as necessary.
		 tp	 	    A date & time conversion�locale-specific am/pm (lower case).
		 tm	 	    A date & time conversion�months in 2 digits, with leading zeroes as necessary.
		 tD	 	    A date & time conversion�date as %tm%td%ty
 		 
 		 FLAG
 		 
 		 08	        Eight characters in width, with leading zeroes as necessary.
 		 +	        Includes sign, whether positive or negative.
 		 ,	        Includes locale-specific grouping characters.
 		 -	        Left-justified..
 		 .3	        Three places after decimal point.
 		 10.3	    Ten characters in width, right justified, with three places after decimal point.		 
		 */
		
		/* IMPORTANTE
			%[indice$][flags][width][.precision]conversion char
			
			se o indice n�o for colocado ele segue a order natural
		*/
		
		//Metodo printf() � usado para exibir dados formatados no console f e de formatted
		 System.out.printf("%1$s %2$s %s \n", "A", "B", "C");
		 
		 String fabio = "Fabio", flavio = "Flavio", luiz = "Luiz";
		 
		 //Foi especificado 2 indices o terceiro n�o ent�o ele volta no 1� indice natural
		 System.out.printf("Filho: %1$s , %2$s Pai: %s ", fabio,flavio,luiz);
		 
		 
		 
		 System.out.println("\n-----------------------------");
		 
		 //Teste String.Split()
		 String[] split = "name:fabio;;sexo:masculino;;".split(";");
		 System.out.println(split.length);
		 for (String palavra : split) {
			System.out.println(palavra);
		}
	}

}
