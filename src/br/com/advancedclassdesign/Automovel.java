package br.com.advancedclassdesign;

import java.io.Serializable;

//Enum pode implementar uma interface
public enum Automovel implements Serializable{
	
	CAMINHAO("CAMINHAO"),
	CARRO("CARRO"),
	MOTO("MOTO"){
		@Override
		public String getDescricao() {
			return "MOTO TOP";
		}
	},
	DRONE,
	TRICICLO("TRICICLO");
	
	
	private String descri��o;
	
	private Automovel(String descricao){
		this.descri��o = descricao;
	}
	
	private Automovel(){// � possivel ter varios construtores no enum
	}
	
	public String getDescricao(){
		return descri��o;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
