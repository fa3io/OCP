package br.com.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class TesteInternacionalizacao {
	
	public static void main(String[] args) {
		
		Locale ptBR = new Locale("pt","BR");
		Locale enUS = new Locale("en","US");
		
		ResourceBundle bundle = ResourceBundle.getBundle("messages",ptBR);
		
		System.out.println(bundle.getString("welcome"));

		
		
	}
}
