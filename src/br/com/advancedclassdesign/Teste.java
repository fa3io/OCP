package br.com.advancedclassdesign;

import java.io.Serializable;

//Interface tem apenas metodos com abstratos e publicos e apenas propriedades public final static
interface Autenticavel{
	int ID_AUTENTICADOR = 10;
	public abstract void autenticar();
}

// Uma Interface pode extender mas de uma interface >> EXTENDS <<
interface Geradora extends Autenticavel, Serializable, Cloneable, Iterable<ContaPessoaFisica>, Comparable<ContaPessoaFisica>{
	
}

abstract class Conta implements Autenticavel{
	//Metodo sem corpo apenas assinatura para quem herdar implementar
	abstract void registrar();
	
	//Pode ter metodos com corpo normal...
	public void registrarMainFraime(){
		System.out.println("Registrando no MainFraime");
	}
}

//Se a classe que herdar for abstrata não é necessario implementar metodos
abstract class ContaPessoaFisica extends Conta{
	abstract void cadastrarCPF(String CPF);
}

//Classe que herda não  é abstrata é obrigada a implementar todos os metodos
class Poupanca extends ContaPessoaFisica{
	@Override
	void cadastrarCPF(String CPF) {	
		System.out.println("Registrando CPF: " + CPF + " .....");
	}
	@Override
	void registrar() {
		System.out.println("Conta Poupança registrada");
	}
	@Override
	public void autenticar() {
		System.out.println("Autenticavel...");
	}
}

class contaCorrente extends Conta{

	//Obrigado a implementar o metodo da classe abstrata
	void registrar() {
		System.out.println("Conta Corrente registrada");
	}
	@Override
	public void autenticar() {
		System.out.println("Autenticavel...");
	}
	
}


public class Teste {
	
	public static void main(String[] args) {
		
		// Conta conta = new Conta();   >>>Não podemos instancia a classe conta pois é abstrata 
		
		//mais podemos ter uma variavel apontando para uma implementação
		Conta conta = new Poupanca();
		conta.autenticar();
		int valor = Autenticavel.ID_AUTENTICADOR;
		
	}

}
