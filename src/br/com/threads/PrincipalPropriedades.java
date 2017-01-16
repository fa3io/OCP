package br.com.threads;

public class PrincipalPropriedades {
	
	static String nome = "./propriedades/Nomes.properties";
	
	public static void main(String[] args) {
		 lerPropriedades();
	}
	
	  public static void lerPropriedades(){
	       new Thread(new Propriedades("1ª",nome)).start();
	       new Thread(new Propriedades("2ª", nome)).start();
	       new Thread(new Propriedades("3ª", nome)).start();
	       new Thread(new Propriedades("4ª",nome)).start();
	    }
}
