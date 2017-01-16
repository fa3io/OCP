package br.com.colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.advancedclassdesign.Carro;

public class Ordenacao {

	public static void main(String[] args) {
		String[] sa = { "charlie", "bob", "andy", "dave" };
		Collections.sort(Arrays.asList(sa), null);
		System.out.println(sa[0]);
		
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro());
		carros.add(new Carro());
		carros.add(new Carro());
		carros.add(new Carro());
		carros.add(new Carro());
		
		//Collections.sort verifica se os objetos da lista implementam comparable e da erro de compilação
		//Collections.sort(carros);
		
		
		
	}

}
