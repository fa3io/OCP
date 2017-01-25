package br.com.localization;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class TesteLocalizacao {

	public static void main(String[] args) {
//------------- Maneiras de Criar Locale ----------------------------
		
		
		//1ª - Construtores
		Locale pt = new Locale("pt");
		Locale pt_BR = new Locale("pt", "BR");
		Locale fb_FB = new Locale("fb", "FB");// Localidade não existe
		Locale pt_BR_variant = new Locale("pt", "BR","");
		
		//pt - Language (Linguagem) da localidade sempre em minusculo
		//BR - Coutry (Pais) da localidade sempre em maiusculo
		//3 parametro - Variant
		
		//2ª Builder - Classe interna dentro de Locale que devolve uma localidade
		Locale LocaleBuilder = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
		
		//3ª Criando com o Metodo Statico forLanguageTag que recebe uma TAG de linguagem
		Locale LocaleTagLanguage = Locale.forLanguageTag("pt-BR");
		
		//4ª Constantes presente na Classe para algumas linguagens
		Locale localeUS = Locale.US;
		
		Locale LOCALE_USADO = pt_BR_variant;
		
		Locale localMaquina = Locale.getDefault(); // Retorna o locale da maquina virtual
		System.out.println("Locale da Maquina: " + localMaquina);

	    Calendar agora = Calendar.getInstance();// vamos obter a data e hora atual

	    // vamos formatar de acordo com o formato de data longa no português brasileiro
	    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, LOCALE_USADO);

	    System.out.println("Data Formatada com Locale(\"pt\", \"BR\") " + dateFormat.format(agora.getTime())); // vamos exibir o resultado 
		
		BigDecimal valor = new BigDecimal("2500.59");
		NumberFormat numberFormat = NumberFormat.getInstance(LOCALE_USADO);
		System.out.println(numberFormat.format(valor.doubleValue()));
		
	}
}
