package br.com.colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deques {

	public static void main(String[] args) {
		
		/* A classe deque pode assumir a estrutura de fila ou de pilha */
		Deque<String> deque = new ArrayDeque<>();
		
		cargaDados(deque);
		
		//coloca na fila equivalente ao addFist
		deque.push("Carla");
		
		//inseri no come�o  e pode lan�ar exce��o
		deque.addFirst("F�bio");
		//inseri no come�o  retorna TRUE se inserido e FALSE se n�o
		boolean adicionouLahis = deque.offerFirst("Lahis");
		
		//inseri no fim e pode lan�ar exce��o
		deque.addLast("Flavio");
		//inseri no final  retorna TRUE se inserido e FALSE se n�o
		boolean adicionouDiene = deque.offerLast("Diene");
		
		//pega o primeiro e pode lan�ar exce��o
		System.out.println(deque.getFirst());
		//pega o primeiro e retorna TRUE ou FALSE
		System.out.println(deque.peekFirst());
		
		//pega o ultimo e pode lan�ar exce��o
		System.out.println(deque.getLast());
		//pega o ultimo e retorna TRUE ou FALSE
		System.out.println(deque.peekLast());
		
		//remove o primeiro retorna o removido ou pode lan�ar exce��o
		System.out.println(deque.removeFirst());
		//remove o primeiro retorna o removido ou null
		System.out.println(deque.pollFirst());
		
		//remove o ultimo retorna o removido ou pode lan�ar exce��o
		deque.removeLast();
		//remove o ultimo retorna o removido ou null
		deque.pollLast();
		
		
		
		
		deque.add("Luiz");// equivalente a addLast(e)
		deque.offer("Rosa");// equivalente a offerLast(e)
		deque.element();//equivalente getFirst()
		deque.peek();//equivalente 	peekFirst()
		deque.remove();//equivalente 	removeFirst()
		deque.poll();//equivalente 	pollFirst()
		
		
		
		deque.push("Gerson");// equivalente addFirst(e)
		deque.pop();// equivalente removeFirst()
		deque.peek();// equivalente peekFirst()
		
		
		
		
		
	}

	private static void cargaDados(Deque<String> deque) {
		deque.add("Maisa");
		deque.add("Carlos");
		deque.add("Lucas");
		deque.add("Meire");
		deque.add("Camila");
		deque.add("Jorge");
		
	}
}
