package br.com.advancedclassdesign;

public class TesteClassesInternas {
	
	
	public static void main(String[] args) {
		// Obtendo classe Externa
		ClasseExterna externa = new ClasseExterna();
		System.out.println(externa.nome);

		// Obtendo classe Interna
		ClasseExterna.Interna interna = externa.new Interna();
		System.out.println(interna.nome);
		System.out.println("Nome Externa: " + interna.getnomeExterna());

		// Obtendo classe interna Estatica
		ClasseExterna.InternaEstatica internaEstatica = new ClasseExterna.InternaEstatica();
		System.out.println(internaEstatica.nome);
		
		//Obtendo dados da classe local 
		System.out.println(externa.getClasselocal());
		
							//Pdemos criar classes anonimas também mas estas não podem ser estaticas
		Cloneable clonavel = new Cloneable() {
			public void clonar(){System.out.println("Clonando");}
		};
		
		//Não é possivel acessar o metodo pois a classe Clonable que é a referencia não possui o metodo
		//clonavel.clonar();
		

	}
}
