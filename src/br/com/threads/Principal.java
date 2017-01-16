package br.com.threads;

public class Principal {

	public static void main(String[] args) {
		
		Impressao impressao = new Impressao("Fabio");
		Impressao impressao1 = new Impressao("Flavio");
		Impressao impressao2 = new Impressao("Luiz");
		
		Thread thread = new Thread(impressao);
		Thread thread1 = new Thread(impressao1);
		Thread thread2 = new Thread(impressao2);
		
		thread.start();
		thread1.start();
		thread2.start();

	}

}
