package br.com.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TesteCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 ExecutorService ex = Executors.newCachedThreadPool();
	        Future<Long> f1 = ex.submit(new FatorialCallable(16L));
	        Future<Long> f2 = ex.submit(new FatorialCallable(7L));
	        Future<Long> f3 = ex.submit(new FatorialCallable(12L));

	        Long total = f1.get() + f2.get() + f3.get();

	        System.out.println(total);

	}

}

class FatorialCallable implements Callable<Long> {
   
	private Long numero;
   
	public FatorialCallable(Long numero) {
        this.numero = numero;
    }
    public Long call() throws Exception {
        Long resultado = 1L;
        for(Long i=numero; i>1; i--){
            resultado *= i;
        }
        return resultado;
    }
}