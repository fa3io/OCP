package br.com.threads;

public class Incrementador implements Runnable {
	public boolean executou = false;
	@Override
	public void run() {
		synchronized (this) {
			PrincipalIncrementador.VARIAVEL += 10;
			executou = true;
			notify();			
		}
	}
}
