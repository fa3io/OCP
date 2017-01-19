package br.com.tryexceptionassert;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.ClosedFileSystemException;

class Arquivo{}

class ArquivoFechavel implements Closeable{
	public void close() throws IOException {
		System.out.println("Fechando Classe ArquivoFechavel-Closable");
	}
}
class ArquivoFechavelRapido extends ArquivoFechavel{
	public void close() throws IOException {
		System.out.println("Fechando Classe ArquivoFechavelRapido");
	}
}

class ArquivoAutoFechavel implements AutoCloseable{
	public void close() throws Exception {
		System.out.println("Fechando Classe ArquivoAutoFechavel-AutoClosable");
		throw new ClosedFileSystemException();
	}	
}

public class UsoTryCatch {
	
	public static void main(String[] args) {
	
		//Codigo abaixo n�o compila pois a classe arquivo n�o implementa  java.lang.AutoCloseable
		//try(Arquivo arquivo = new Arquivo()){}
		
		
		try(ArquivoFechavel arquivo = new ArquivoFechavel()){
			// arquivo = new ArquivoFechavelRapido();//Quando uma variavel � criada dentro do try ela se torna final 
													//n�o podendo atribuir novos valores a ela, erro de copilacao
			
		} catch (IOException | NullPointerException exception) {
			//exception = new ArrayIndexOutOfBoundsException(); //Quando temos multi-catch a varivel tamb�m fica final
																//n�o podendo atribuir novos valores a ela, erro de copilacao
		
			//arquivo.close(); //N�o temos acesso ao recurso  no catch compilacao
		
		}finally {
			//arquivo.close(); // nem no finally erro de compilacao  
		}

		try{
			ordemTryCatchFinally();			
		}catch(Exception exception){
			System.out.println("########## Execao Capturada Lancada pelo Finally ##########");
			System.out.println("Classe: "+exception.getClass());
			System.out.println("Classe: "+exception.getMessage());
		}
		
		try(ArquivoFechavel arquivoFechavel = new ArquivoFechavel();
			ArquivoFechavelRapido arquivoFechavelRapido = new ArquivoFechavelRapido()){//Recursos s�o fechados na ordem inversa de criacao
			
			System.out.println("########## ORDEM DE FECHAMENTO ##########");
		}catch(Exception exception){
			
		}
		
		
		
	}

	private static void ordemTryCatchFinally() {
		
		//Primeiro � executado tudo dentro do try
		//Em Segundo lugar � executado tudo dentro do metodo close do recurso
		//Em terceiro � executado o catch se ocorrer alguma exce��o 
		//E por ultimo e sempre o finally � executado 
		try(ArquivoAutoFechavel arquivoAutoFechavel = new ArquivoAutoFechavel()) {
			System.out.println("########## ORDEM DOS COMANDOS ##########");
			System.out.println("Bloco TRY");
			throw new IllegalArgumentException("Mensagem Lan�ada Pelo Try");
		} catch (Exception e) {
			//Consegue capturar a IllegalArgumentException lancada pelo try e dentro dela uma excecao suprimida
			//que foi lan�ada pelo metodo close do recurso
			System.out.println("Exception Suprimida: " + e.getSuppressed()[0]);
			System.out.println("Bloco CATCH");
		}finally{
			System.out.println("Bloco FINALLY");
			throw new ArrayIndexOutOfBoundsException("Mensagem Lan�ada Pelo Finally");
		}
	}
}
