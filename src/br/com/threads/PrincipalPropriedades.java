package br.com.threads;

public class PrincipalPropriedades {
	
	static String nome = "./propriedades/Nomes.properties";
	
	public static void main(String[] args) {
		 lerPropriedades();
	}
	
	  public static void lerPropriedades(){
	       new Thread(new Propriedades("1�",nome)).start();
	       new Thread(new Propriedades("2�", nome)).start();
	       new Thread(new Propriedades("3�", nome)).start();
	       new Thread(new Propriedades("4�",nome)).start();
	    }
}
