package br.com.string;

import java.util.StringTokenizer;

public class Tokens {

	public static void main(String[] args) {
		
		
		
		
		// Delimitadores que podem ser usados " \t\n\r\f"
		 String str = "tokens\twith tabs and \r\nnew lines.";
		 StringTokenizer st = new StringTokenizer(str);
		 System.out.println(st.countTokens());
		 
		 
		 //No construtor entra a String a ser analisada e o delimitador
		 StringTokenizer tokens = new StringTokenizer("aa a aaaa", "a");
		 System.out.println(tokens.countTokens());
	
		 while (tokens.hasMoreTokens()) {
			 System.out.println(tokens.nextToken());
		 }
		
	}

}
