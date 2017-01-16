package br.com.threads;

public class ID implements Runnable{

	private String nome;
	public ID(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 1000; i++) {
			System.out.println(nome +" "+ i);
		}
		
	}

}


