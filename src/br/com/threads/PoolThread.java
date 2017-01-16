package br.com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThread implements Runnable {

	 private static Integer total = 0;

	    public static void main(String[] args) {
			//Criando o executor de threads
			ExecutorService executor = Executors.newCachedThreadPool();
			//Executando 
			
			for(int i=0; i<10; i++){
				executor.execute(new PoolThread());
				
	        }
			//Encerrando as Threads
			executor.shutdown();
	    }

	    @Override
	    public void run() {
	        for(int i=0; i<10; i++){
	            synchronized (total) {
	                total++;
	                System.out.println(total);
	            }
	        }
	    }
	    

}
