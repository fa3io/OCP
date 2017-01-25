package br.com.localization;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatadores {

	public static void main(String[] args) {
		
		Locale pt_BR = new Locale("pt", "BR");
		
		/**
		 * Existem formatadores que utilizam do Locale para funconar:
		 */
		
		/**Conseguindo uma instacia de NumberFormat 
		 * 
		 * Lembrando que metodos fabrica na maioria das vezes sao chamados getInstance() ou getXXXInstance() 
		 */
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat = NumberFormat.getInstance(pt_BR);
		numberFormat = DecimalFormat.getCurrencyInstance(); // DicmalFormt extends NumberFormat por isso é possivel
		numberFormat = DecimalFormat.getCurrencyInstance(pt_BR); // DicmalFormt extends NumberFormat por isso é possivel
		
		Format formatter = NumberFormat.getCurrencyInstance(pt_BR);// Caiu em exercicio NumberFormat extends Format por isso é possivel
		
		
		/** Tambem temos a classe de formatação de Data SimpleDateFormat */
		
		/**
Simbolo 	Significado             Apresentacao	Exemplo
	G	   era designator	         Text	           AD
	y	   year	                     Number	          2009
	M	   month in year	         Text & Number	July & 07
	d	   day in month	             Number	           10
	h	   hour in am/pm (1-12)	     Number	           12
	H	   hour in day (0-23)	     Number	            0
	m	   minute in hour	         Number	           30
	s	   second in minute	         Number	           55
	S	   millisecond               Number	          978
	E	   day in week	             Text            Tuesday
	D	   day in year	             Number	          189
	F	   day of week in month	     Number	    2 (2nd Wed in July)
	w	   week in year	             Number	           27
	W	   week in month	         Number             2
	a	   am/pm marker	             Text              PM
	k	   hour in day (1-24)	     Number	           24
	K	   hour in am/pm (0-11)	     Number	            0
	z	   time zone	             Text  	   Pacific Standard Time
	'	   escape for text	         Delimiter	      (none)
	'	   single quote	             Literal	        '
		 */
		
		
		Date hoje = new Date();
		
		SimpleDateFormat formatador = new SimpleDateFormat("EEE d MM yyyy", Locale.getDefault());
		System.out.println(formatador.format(hoje));
		
		
		
		String dataFormatada;
		String tempoFormatado;
		String dataTempoFormatado;
		
		DateFormat formatadorData;
		DateFormat formatadorTempo;
		DateFormat formatadorDataTempo;
		
		/** Estios de formatacao DEFAULT, SHORT, MEDIUM, LONG, FULL */
		formatadorData = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault());
		formatadorTempo = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.getDefault());
		formatadorDataTempo = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,Locale.getDefault());

		dataFormatada = formatadorData.format(hoje);
		tempoFormatado = formatadorTempo.format(hoje);
		dataTempoFormatado = formatadorDataTempo.format(hoje);
		
		System.out.println(dataFormatada + " " + Locale.getDefault().toString());
		System.out.println(tempoFormatado + " " + Locale.getDefault().toString());
		System.out.println(dataTempoFormatado + " " + Locale.getDefault().toString());
		
		
		

		

	}

}
