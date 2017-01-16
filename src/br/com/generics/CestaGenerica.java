package br.com.generics;

import java.util.List;

public class CestaGenerica <F> {
	
	F instance;

	public void put(F f){
		instance = f;
	}
	
	public F nextItem(){
		return instance;
	}

	public boolean hasItems(){
		return instance != null;
	}
	
	public <E> boolean compare(E hi, E other){
		return true;
	}

	public <E> E compare(List<E> list){
		
		return (E) new Object();
	}
}
