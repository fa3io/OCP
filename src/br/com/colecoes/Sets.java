package br.com.colecoes;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		/*Interface Set n�o permite elementos duplicados
		 * 
		 */
		
		
		//Rapido mas n�o tem ordem certa
		//Aceita null
		Set<Pessoa> hashSet = new HashSet<Pessoa>();
		
		//Manter ordem a ordem mas a classe precisa implementar a interface comparable
		//ClassCastException(RuntimeException) � lan�ada pois ele tenta fazer cast para Comparable;
		//TreeSet n�o aceita inser��o de null
		Set<Pessoa> treeSet;
		
		//Mistura de HashSet e TreeSet rapido e manter a ordem de inser��o
		Set<Pessoa> linkedHashSet = new LinkedHashSet<Pessoa>();
		
		Pessoa fabio = new Pessoa(1, "Fabio", 25);
		Pessoa lais = new Pessoa(20, "lais", 25);
		Pessoa fabio2 = new Pessoa(1, "Fabio Santos Alves", 25);
		Pessoa flavio = new Pessoa(2, "Flavio", 22);
		Pessoa luiz = new Pessoa(5, "Luiz", 49);
		Pessoa rosa = new Pessoa(10, "Rosa", 52);
		Pessoa jeni = new Pessoa(15, "Jeni", 20);
	
		// H� ganho ao inserir elementos em um HashSet ao inv�s de em um TreeSet
		hashSet.add(rosa);
		hashSet.add(jeni);
		hashSet.add(flavio);
		hashSet.add(luiz);
		hashSet.add(lais);
		boolean add1 = hashSet.add(fabio);
		boolean add2 = hashSet.add(fabio2);
		
		System.out.println("Primeira Inser��o de Fabio: " + add1);
		System.out.println("Segunda Inser��o de Fabio: " + add2);
		

		System.out.println("------ HashSet ------");
		System.out.println(hashSet);

		// Uma vez inseridos, converta para TreeSet para ordena��o Natural(Por codigo)
		//Aceita null
		treeSet = new TreeSet<Pessoa>(hashSet);
		
		System.out.println("------ TreeSet ------");
		System.out.println(treeSet);
		
		//LinkedHashSet guarda a ordem de inser��o
		linkedHashSet.add(jeni);
		linkedHashSet.add(luiz);
		linkedHashSet.add(flavio);
		linkedHashSet.add(rosa);
		linkedHashSet.add(fabio);
		linkedHashSet.add(lais);
		linkedHashSet.add(null);
		
		System.out.println("------ LinkedHashSet ------");
		System.out.println(linkedHashSet);
		

	}
}
