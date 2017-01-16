package br.com.colecoes;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TesteNavigableSet {
	public static void main(String[] args) {
		
		NavigableSet<Integer> navigableSet = new TreeSet<>();
		
		
		navigableSet.add(1);
		navigableSet.add(5);
		navigableSet.add(10);
		navigableSet.add(15);
		navigableSet.add(21);
		navigableSet.add(22);
		
		//Retorna o maior elemento neste conjunto menor ou igual ao determinado elemento, 
		//ou nulo se não houver tal elemento.
		System.out.println(navigableSet.floor(5));
		
		 //Retorna o menor elemento neste conjunto maior ou igual ao determinado elemento, 
		//ou nulo se não houver tal elemento.
		System.out.println(navigableSet.ceiling(11));
		
		 //Retorna o maior elemento neste conjunto estritamente inferior ao dado elemento, 
		//ou nulo se não houver tal elemento.
		System.out.println(navigableSet.lower(15));
		
		//Retorna o menor elemento neste conjunto estritamente maior que o dado elemento, 
		//ou nulo se não houver tal elemento.
		System.out.println(navigableSet.higher(21));
		
		
		
	}
}
