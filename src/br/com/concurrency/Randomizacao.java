package br.com.concurrency;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizacao {

	public static void main(String[] args) {
		
		int randon = ThreadLocalRandom.current().nextInt(1, 11);

	}

}
