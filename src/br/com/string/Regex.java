package br.com.string;

public class Regex {

	public static void main(String[] args) {

		/*MODIFICADORES
		 * 
		 * (?i) Ignora Maiusculas e minusculas
		 * (?x) Reconhece Comentario
		 * (?m) Multilinhas
		 * (?s) Dottal
		 */
	
		System.out.println("########## MODIFICADORES ##########");
		System.out.println("Java".matches("(?i)java"));
		//testar os outros posteriormente
		
		
		/*METACARACTERE
		 
		 .      Qualquer caractere
		 \d     Digitos[0-9]
		 \D		n�o digitos [^0-9]
		 \s		espa�os [\t\n\x0B\f\r]
		 \S		nao espa�os
		 \w		letras[a-zA-Z_0-9]
		 \W		n�o � letra
		 */
		System.out.println("########## METACARACTERES ##########");
		System.out.println("F".matches("\\w"));
		System.out.println("L".matches("."));
		System.out.println("8".matches("\\d"));
		System.out.println("".matches("\\s"));
		System.out.println(" ".matches("\\s"));
		System.out.println("".matches("\\S"));
		System.out.println("A".matches("\\d"));
		System.out.println("8".matches("\\W"));
		System.out.println("".matches("."));
		
		
		/* QUANTIFICADORES
		
		 x{n}		X,exatamente n vezes
		 x{n,}		X,pelo menos n vezes
		 x{n,m}		X,pelo menos n vezes e n�o mais de m vezes
		 x?			X,0 ou 1 vez
		 x*			X,0 ou + vezes
		 x+			X,1 ou + vezes
		*/
		
		System.out.println("########## QUANTIFICADORES ##########");
		System.out.println("38412-448".matches("\\d{5}-\\d{3}"));
		System.out.println("3227-5350".matches("\\d{4}-\\d{4}"));
		System.out.println("34 3227-5350".matches(".{3}\\d{4}-\\d{4}"));
		System.out.println("Fabio".matches("\\w{1,}"));
		System.out.println("FabioSantosAlves".matches("\\w{1,16}"));
		System.out.println("10".matches("\\d?"));
		System.out.println("1".matches("\\d*"));
		System.out.println("UM".matches("\\d+"));
		
		/*METACARACTERES DE FRONTEIRA
		 
		 ^		Inicia com
		 $		Finaliza com
		 |		Ou
		
		*/
		
		System.out.println("########## METACARACTERES DE FRONTEIRA ##########");
		
		System.out.println("Fabio Santos Alves".matches("^F.*"));
		System.out.println("Rosalina".matches("^R\\w{6}a$"));
		
		
		
		/*AGRUPADORES
		 
		 [...]				Agrupamento de caracteres
		 [a-z]				Alcance ou intervalo entre a at� z
		 [a-e][i-u]			Uni�o entre a at� e e entre i at� u
		 [a-z&&[aeiou]]		Interse��o entre a at� z mais as vogais aeiou
		 [^abc]				Exce��o tudo menos abc
		 [a-z&&[^m-p]]		Subtra��o entre a at� z menos de m at� p
		 \x					Fuga literal
		 */
		
		System.out.println("########## AGRUPADORES ##########");
		

	}

}
