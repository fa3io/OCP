package br.com.tryexceptionassert;

//S�o apontadas em tempo de compilacao
class MinhaExceptionChecked extends Exception{}
//S�o apontadas em tempo de execucao
class MinhaExceptionUnchecked extends RuntimeException{}



public class Exceptions {
	
	
	public static void main(String[] args) {
	
	//Ou lancamos a execao ou a tratamos com um try/catch
	try {
		metodoChecked();
	} catch (MinhaExceptionChecked e) {

	}
	
	
	//Nao precisamos tratar pois ela ser� lancada em tempo de execucao
	metodoUnchecked();
	
	
	}
	
	
	
	
	
	
	
	//Metodos que lancam execoes chegadas s�o obrigados a especificar isso na assinatura
	public static void metodoChecked() throws MinhaExceptionChecked{
		throw new MinhaExceptionChecked();
	}
	
	//Excecoes n�o checadas n�o � necessario avisar na assinatura
	public static void metodoUnchecked(){
		throw new MinhaExceptionUnchecked();
		
	}
	
	

}
