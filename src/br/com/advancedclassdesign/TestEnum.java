package br.com.advancedclassdesign;

public class TestEnum {
	
	public static void main(String[] args) {
		
		Automovel carro = Automovel.CAMINHAO;
		
		for (Automovel automovel : Automovel.values()) {
			System.out.println(automovel.name()); // nome do enum
			System.out.println(automovel.ordinal()); // ordem de declaração apartir de 0
			System.out.println(automovel.toString()); // Padrao retornar o nome do enum
			System.out.println(automovel.getDeclaringClass());
			System.out.println("---------------------------");
		}
		
	}

}
