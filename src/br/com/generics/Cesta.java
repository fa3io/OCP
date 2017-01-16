package br.com.generics;

public class Cesta {
	
	public void put(Object o){

	}
	
	public Object nextItem(){
		return new Object();
	}

	public boolean hasItems(){
		return false;
	}
	
	public <E> E remover(E instance){
		return instance;
	}
}
