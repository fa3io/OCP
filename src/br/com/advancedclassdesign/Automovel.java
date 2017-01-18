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
	
	
	private String descricao;
	
	private Automovel(String descricao){
		this.descricao = descricao;
	}
	
	private Automovel(){// Eh possivel ter varios construtores no enum
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
