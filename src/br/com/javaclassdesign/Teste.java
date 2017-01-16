package br.com.javaclassdesign;


/*
 * Modificadores de acesso
 * 
 * public  - de qualquer lugar
 * protected - herdar mesmo pacote
 * default (sem nada) - mesmo pacote, dentro de mim
 * private - dentro de mim
 * 
 */

class Carro{
	
	public void acelerar(){
		System.out.println("Carro Acelerando");
	}
	private void freiar(){
		System.out.println("Carro freiando");
	}
	public void usarFreio(){
		freiar();
	}
	public static void ObterMotor(){
		System.out.println("Motor Normal");
	}
}

class CarroEletrico extends Carro{
	
	public void acelerar() {
		System.out.println("Eletrico Acelerando ");
	}
	private void freiar(){
		System.out.println("Eletrico freiando");
	}
	public void usarFreio(){
		freiar();
	}
	public static void ObterMotor(){
		System.out.println("Motor Eletrico");
	}
}

public class Teste {

	public static void main(String[] args) {
		Carro carroEletrico = new CarroEletrico();
		
		carroEletrico.acelerar();
		carroEletrico.usarFreio();
		carroEletrico.ObterMotor();
	}

}
