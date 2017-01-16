package br.com.string;

public class StringStringBuilder {
	public static void main(String[] args) {
		 StringBuilder sb = new StringBuilder("8"); 
		 int i = 8; 
		 
		 //Não compila pois não é possivel concatenar int+StringBuilder
		 //System.out.println(8 + i + sb);
		 
		 //Compila normalmente pois podemos concatenar
		 System.out.println(8 + i + sb.toString());
		 
	}
}
