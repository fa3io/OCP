package br.com.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Listas {
	
	/*Lista podem ter elementos duplicados*/
	
public static String getList(List<? extends Number> lista){
	
	/*parametros de entrada como :
		List<? super Number>
		List<? extends Number>
		List<?>  igual List<? extends Object>
	Não podemos adicionar nada na lista pois não sabemos qual o tipo certo que vira
	Teremos um erro de copilação
	*/
	return "Recebimento de lista parametro com generics ";
}
	
	//List é uma interface extend de Collection
	private static List<Pessoa> list; 
	
	//ArrayList implementação de List internamente trata como uma arraylist
	private List<Pessoa> arrayList = new ArrayList<>();
	
	private List<Pessoa> linkedList = new LinkedList<>();
	
	public static void main(String[] args) {
		
		Pessoa fabio = new Pessoa(1, "Fabio", 25);
		list.add(fabio);
		Pessoa lais = new Pessoa(20, "lais", 25);
		list.add(lais);
		Pessoa fabio2 = new Pessoa(1, "Fabio Santos Alves", 25);
		list.add(fabio2);
		Pessoa flavio = new Pessoa(2, "Flavio", 22);
		list.add(flavio);
		Pessoa luiz = new Pessoa(5, "Luiz", 49);
		list.add(luiz);
		Pessoa rosa = new Pessoa(10, "Rosa", 52);
		list.add(rosa);
		Pessoa jeni = new Pessoa(15, "Jeni", 20);
		list.add(jeni);
		
		getList(new ArrayList<Number>());
		
		
		Collections.sort(list, null);
	
	}

}
