package br.com.threads;

public class Impressao implements Runnable {

	private String nome;
	
	public Impressao(String nome) {
		this.nome = nome; 
	}

	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			System.out.println(nome +" "+ i);
		}
	}

}
