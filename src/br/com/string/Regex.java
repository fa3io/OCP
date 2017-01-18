package br.com.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		 \D		não digitos [^0-9]
		 \s		espaços [\t\n\x0B\f\r]
		 \S		nao espaços
		 \w		letras[a-zA-Z_0-9]
		 \W		não é letra
		 \b		Caracter de palavra no começo da string ou no final da string ou no meio entre um caractere de palavra (\w)
		  		e um caractere que não é de palavra (\W)
		  		*Caractere de palvra e um caractere que pode-se formar uma frase com o mesmo
		 
		 \B		Busca caracteres que não são de palavra
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
		System.out.println("Fabio".matches("\\bF.*"));
		
		
		/* QUANTIFICADORES
		
		 x{n}		X,exatamente n vezes
		 x{n,}		X,pelo menos n vezes
		 x{n,m}		X,pelo menos n vezes e não mais de m vezes
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
		System.out.println("LuizSilva".matches("^L.*Silva|Alves"));
		System.out.println("Marta".matches("M.*ta$"));
		
		/*AGRUPADORES
		 
		 [...]				Agrupamento de caracteres
		 [a-z]				Alcance ou intervalo entre a até z
		 [a-e][i-u]			União entre a até e e entre i até u
		 [a-z&&[aeiou]]		Interseção entre a até z mais as vogais aeiou (comum entre os dois)
		 [^abc]				Exceção tudo menos abc
		 [a-z&&[^m-p]]		Subtração entre a até z menos de m até p
		 \x					Fuga literal para usar o caractere propriamente dito
		 
		 */
		
		System.out.println("########## AGRUPADORES ##########");
		
		System.out.println("Flavio".matches("Fl[ao]vio"));
		System.out.println("3227-5350".matches("[0-9]{4}-[0-9]{4}"));
		System.out.println("3210-3300".matches("[0-9&&[0123]]+-\\d{4}"));
		System.out.println("olho".matches("[^a]lho"));
		System.out.println("3210-3300".matches("[0-9&&[^4-9]]+-[0-9&&[^4-9]]+"));
		
		System.out.println("########## Classe Pattern e Matcher ##########");
		
		Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		String frase = "Java linguagem moderna de programação, o jAva tem dominado o desenvolvimento Web, o jaVa não é tão bom para desenvolvimento Desktop mas o javA é otimo!";
		
		Matcher matcher = pattern.matcher(frase);
		
		
		while (matcher.find()) {
			System.out.println("Inicio: "+ matcher.start()+" Palavra: "+matcher.group());
		}
		
		
		
	}

}
