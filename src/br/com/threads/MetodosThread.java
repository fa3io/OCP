package br.com.threads;

public class MetodosThread {

	public static void main(String[] args) {
		
		/**
		 * Criamos thread de duas maneiras:
		 * 
		 * Estendendo a class Thread.
		 * Implementando a interface Runnable.
		 */
		

		try {
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println("Rodando a Thread!!");
			}
		};
		
		/**
		 * O mecanismo de sincronização é suficiente para evitar que as threads interfiram umas com as outras, mas pode ocorrer
		 *a necessidade de as threads se comunicarem. Os métodos wait(), notify() e notifyAll() têm o propósito de permitir a comunicação entre as threads.
		 *	O método wait() faz com que a thread fique em estado de espera até que determinada condição aconteça.
		 *	Os métodos notify() e notifyAll() informam às threads, em estado de espera, que alguma coisa ocorreu e que pode satisfazer àquela condição. 
		 
		 *
		 *
		 *
		 * Uma chamada para wait (), notify () e notifyAll () devem sempre ser colocadas dentro de um bloco sincronizado.
		 */
		synchronized (thread) {
			
		
		
		thread.start(); // Inicia Uma thread
		thread.sleep(5000); // Faz a thread dormir por um determinado tempo
		thread.wait();//Coloca a thread corrente em estado de espera e libera o lock em objetos até que outra thread chame os métodos notify ou notifyAll liberando o objeto e o lock é reestabelecido.
		thread.wait(100);
		thread.notify();//Acorda a thread que, voluntariamente, estava esperando a liberação de um objeto.
		thread.notifyAll();//Acorda todas as threads que estavam esperando a liberação de um objeto.
		thread.interrupt();//Atribui à thread o estado de interrompível
		thread.isInterrupted();//Verifica se foi atribuído à thread o estado de interrompível.
		thread.join();//Condiciona a continuação da execução de uma thread ao término de uma outra. 
		thread.yield();//Faz com que a thread corrente pause, possibilitando que outra thread seja despachada.
		
		
		}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
