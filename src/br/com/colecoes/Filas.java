package br.com.colecoes;

import java.util.PriorityQueue;
import java.util.Queue;

public class Filas {
	
	//TODO - A Fazer
	//FIXME - BUG para corrigir
	//XXX - A Refatorar
	// Comentarios acimas aparecem na tela TASK
	
	public static void main(String[] args) {
		Queue<Pessoa> pessoas = new PriorityQueue<>();
		
		boolean incluido = pessoas.add(new Pessoa(1, "Fabio", 25));
		pessoas.add(new Pessoa(4, "Pedro", 21));
		pessoas.add(new Pessoa(3, "Carla", 24));
		pessoas.offer(new Pessoa(2, "Maria", 26));
		
		System.out.println("Fábio foi incluido? " + incluido);
		
		System.out.println(pessoas);
		
		//Consulta e remove um nodo da fila. Retorna null se a fila está vazia 
		Pessoa pessoaRemovida = pessoas.poll();
		
		
		
		Pessoa peek = pessoas.peek();
		System.out.println("Peek: " + peek);
		
		//Remove -> apenas remove e devolve boolean
		boolean removida = pessoas.remove(new Pessoa(3, "Carla", 24));
		
		System.out.println("Poll: " + pessoaRemovida);
		System.out.println("Remove: " + removida);
		
		System.out.println("element: " + pessoas.element());
		
		System.out.println(pessoas);
		pessoas.offer(new Pessoa(5, "Ameia", 25));
		
		System.out.println(pessoas);
		
		pessoas.add(new Pessoa(10, "Carlos", 20));
		pessoas.offer(new Pessoa(10, "Carlos", 20));
		pessoas.clear();
		pessoas.contains(new Pessoa(10, "Caros", 20));
		pessoas.iterator();
		Pessoa peek2 = pessoas.peek();
		System.out.println(peek2);// Devolve null se fila estiver vazia
		//pessoas.element(); // Lança exceção se afila estiver vazia
		pessoas.poll(); // Devolve null se fila estiver vazia
		//pessoas.remove(); // Lança exceção se afila estiver vazia
		pessoas.size();
		
		

		
	}

	
	
}
