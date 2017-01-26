package br.com.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VariaveisAtomicas {
	

	public static void main(String[] args) {
		
		/**
		 * No pacote java.util.concurrent.atomic
		 * 
		 * Temos tipos simples que podemos manipular e não sofrer o efeito de um acesso simultaneo.
		 * Basicamente sao wrappers dos tipos primitivos mas são volatile para poderem ser acessados por threads 
		 * e não ser necessario encher o codigo synchronized
		 */
		
		
		AtomicInteger integerAtomico = new AtomicInteger();
		
		integerAtomico.set(10);
		integerAtomico.incrementAndGet();
		integerAtomico.addAndGet(5);
		integerAtomico.decrementAndGet();
		System.out.println(integerAtomico.get());
		
		
		AtomicBoolean booleanAtomico = new AtomicBoolean();
		
		booleanAtomico.set(true);
		System.out.println(booleanAtomico.get());
		
		AtomicLong longAtomico = new AtomicLong();
		
		longAtomico.set(100000);
		longAtomico.incrementAndGet();
		longAtomico.addAndGet(123);
		longAtomico.decrementAndGet();
		System.out.println(longAtomico.get());
		

	}

}
