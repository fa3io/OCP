package br.com.advancedclassdesign;

import java.io.Serializable;

public class ClasseExterna {
	public String nome = "Externa";

	// Classe aninhada normal
	//classes Interna podem impementar interfaces e externder classe
	public class Interna  extends Object implements Serializable{
		
		//Classes internas so podem ter campos estaticos se os mesmos forem finais --não podem conter metodos estaticos
		final static String campoEstatico = "Campo Estatico";

		private static final long serialVersionUID = 1L;
		public String nome = "Interna";
		public String nomeExterna = ClasseExterna.this.nome;// classe interna pode acessar dados da classe externa
		
		String getnomeExterna(){
			System.out.println("ClasseExterna.this.nome: " + ClasseExterna.this.nome);
			System.out.println("Interna.this.nome: " + Interna.this.nome);
			
			return nomeExterna;
		}
	}
	

	// Classe aninhada statica
	public static class InternaEstatica {
		public String nome = "InternaEstatica";
	}

	public void useClasses() {

		//Para obtermos uma classe interna normal precisamos da instancia da externa
		Interna interna = new ClasseExterna().new Interna();
		String classe = interna.nome;
		System.out.println(classe);
		
		//Para obtermos uma classe Estatica podemos usar instancia da externa
		InternaEstatica estatica = new ClasseExterna.InternaEstatica();
		String classeEstatica = estatica.nome;
		System.out.println(classeEstatica);
	
		//Dentro da classe externa podemos instanciar a classe interna sem referencia
		String internaSemInstanciarExterna = new Interna().nome;
		System.out.println(internaSemInstanciarExterna);
		
		//Instanciando classe interna apenas 
		String internaInstanciandoApenasExterna = new ClasseExterna.Interna().nome;
		System.out.println(internaInstanciandoApenasExterna);
	}

	public String getClasselocal(){
		
		//Classe local criada dentro do metodo
		//Não pode implementar e extender outras classes ou interfaces
		//Não pode ser estatica
		class Local {
			public String nome = "Local";
			
		}
		
		return new Local().nome;
	}
}