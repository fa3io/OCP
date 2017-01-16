package br.com.threads;

public class PrincipalIncrementador {

	public static int VARIAVEL;

	public static void main(String[] args) throws InterruptedException {

		Incrementador i1 = new Incrementador();
		Incrementador i2 = new Incrementador();

		new Thread(i1).start();
		new Thread(i2).start();

		synchronized (i1) {
			if (!i1.executou) {
				i1.wait();
			}
			synchronized (i2) {
				if (!i2.executou) {
					i2.wait();
				}
				System.out.println(VARIAVEL);
			}
		}
	}

}
