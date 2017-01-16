package br.com.threads;

import java.io.File;

public class DeadLock {
	
	static File arquivo1 = new File("");
	static File arquivo2 = new File("");

	public static void main(String[] args) {
		PegaArquivo pa1 = new PegaArquivo("Thread 1",arquivo1 ,arquivo2 );
		PegaArquivo pa2 = new PegaArquivo("Thread 2",arquivo1 ,arquivo2 );
		
		new Thread(pa1).start();
		new Thread(pa2).start();
	}
}


class PegaArquivo implements Runnable{

	File arquivo1;
	File arquivo2;
	String nomeThread;
	
	public PegaArquivo(String nome, File arquivo, File arquivo2) {
		this.nomeThread = nome;
		this.arquivo1 = arquivo;
		this.arquivo2 = arquivo2;
	}
	
	@Override
	public void run() {
	
		synchronized (arquivo1) {
			System.out.println(nomeThread+ " Adquiriu o arquivo 1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			synchronized (arquivo2) {
				System.out.println(nomeThread + " Adquiriu arquivo 2");
				System.out.println(nomeThread + " Executou!!!");
			}
		
		
		
		}
		
	}
	
}