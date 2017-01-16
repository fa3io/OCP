package br.com.threads;

public class TesteVolatile implements Runnable {

	    private static volatile double total = 1;

	    public static void main(String[] args) {

	        new Thread(new TesteVolatile()).start();

	        new Thread(new TesteVolatile()).start();

	        new Thread(new TesteVolatile()).start();

	        new Thread(new TesteVolatile()).start();

	        new Thread(new TesteVolatile()).start();

	    }

	    @Override
	    public void run() {

	        for (int i = 0; i < 50; i++) {

	            total = total * 1.5;

	            System.out.println(total);

	        }

	    }

	}
