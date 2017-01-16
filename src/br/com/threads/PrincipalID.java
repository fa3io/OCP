package br.com.threads;

public class PrincipalID {
	
	

	public static void main(String[] args) {
		ID id1 = new ID("Primeira");
		ID id2 = new ID("Segunda");

		Thread t1 = new Thread(id1);
		Thread t2 = new Thread(id2);
		
		t1.start();
		t2.start();
	}
}
