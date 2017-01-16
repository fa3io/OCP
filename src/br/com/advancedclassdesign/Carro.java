package br.com.advancedclassdesign;


 public class Carro {
	 
	 private class Usuario{
		 public String condutor = "Fabio Santos Aves"; 
	 }
	
	
	 
	//public todo mundo pode acesso
	public String cor; // null
	
	//protected mesmo pacote herança
	protected int portas; // 0
	
	//Default 
	boolean bancoDeCouro; // false
	
	//private 
	private boolean arCondicionado = false;
	
	
	public void ligarAr(boolean ligar){
		if(ligar == true){
			cor = "Verde";
		}
		this.arCondicionado = ligar;
	}
	
	
}
