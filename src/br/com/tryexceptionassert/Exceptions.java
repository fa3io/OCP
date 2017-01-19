package br.com.tryexceptionassert;

//São apontadas em tempo de compilacao
class MinhaExceptionChecked extends Exception{}
//São apontadas em tempo de execucao
class MinhaExceptionUnchecked extends RuntimeException{}



public class Exceptions {
	
	
	public static void main(String[] args) {
	
	//Ou lancamos a execao ou a tratamos com um try/catch
	try {
		metodoChecked();
	} catch (MinhaExceptionChecked e) {

	}
	
	
	//Nao precisamos tratar pois ela será lancada em tempo de execucao
	metodoUnchecked();
	
	
	}
	
	
	
	
	
	
	
	//Metodos que lancam execoes chegadas são obrigados a especificar isso na assinatura
	public static void metodoChecked() throws MinhaExceptionChecked{
		throw new MinhaExceptionChecked();
	}
	
	//Excecoes não checadas não é necessario avisar na assinatura
	public static void metodoUnchecked(){
		throw new MinhaExceptionUnchecked();
		
	}
	
	

}
