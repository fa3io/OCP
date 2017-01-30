package br.com.colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Mapas {
	
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> treehMap = new TreeMap<>();

		String entrada1 = hashMap.put(1, "Fabio");
		
		System.out.println("Retorno Entrada 1 : " + entrada1);
		
		String entrada2 = hashMap.put(1, "Fabio Denovo");
		
		System.out.println("Retorno Entrada 2 : " + entrada2);
		
		System.out.println("HasMap Contem agora: " + hashMap.values());
		
		
		
		
		/* Maps de concurrence*/
		
		Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
		
		concurrentHashMap.put(null, null);
		
		
		//inserção de null
		//concurrentHashMap.put(null, null);
		
		hashMap.put(null, "Chave nula");
		hashMap.put(null, "Fabio nula");
		//treehMap.put(null, null);
		
		System.out.println("Chave nulla"+hashMap.get(null));
		
		
	}
    
}   
    