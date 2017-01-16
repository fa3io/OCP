package br.com.advancedclassdesign;


class Veiculo {}
class CarroEletrico extends Veiculo {}
class Moto extends Veiculo{}
class SuperBike extends Moto{}
class Aviao extends Veiculo{}
class Boing extends Aviao{}

public class UsandoInstanceOf {
	
	
	//InstanceOf � usado apenas quando as classes tem rela��o
	//Se n�o tiver rela��o nem compila
	
	public static void main(String[] args) {
		
	CarroEletrico carroEletrico = new CarroEletrico();
	Moto moto = new Moto();
	Boing boing = new Boing();
	Aviao aviao = new Aviao();
	Veiculo veiculo = new Veiculo();
	
	//Compativeis por hera�a e polimorfismo
	System.out.println(carroEletrico instanceof Veiculo);
	System.out.println(moto instanceof Veiculo);
	System.out.println(boing instanceof Veiculo);
	System.out.println(boing instanceof Aviao);	
	
	
	//compativel por heran�a mas retorna false
	System.out.println(veiculo instanceof Aviao);	
	System.out.println(aviao instanceof Boing);	
	System.out.println(moto instanceof SuperBike);	
		
		
	}
}



