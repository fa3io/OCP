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
	
		//Codigo abaixo não compila pois a classe arquivo não implementa  java.lang.AutoCloseable
		//try(Arquivo arquivo = new Arquivo()){}
		
		
		try(ArquivoFechavel arquivo = new ArquivoFechavel()){
			// arquivo = new ArquivoFechavelRapido();//Quando uma variavel é criada dentro do try ela se torna final 
													//não podendo atribuir novos valores a ela, erro de copilacao
			
		} catch (IOException | NullPointerException exception) {
			//exception = new ArrayIndexOutOfBoundsException(); //Quando temos multi-catch a varivel também fica final
																//não podendo atribuir novos valores a ela, erro de copilacao
		
			//arquivo.close(); //Não temos acesso ao recurso  no catch compilacao
		
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
			ArquivoFechavelRapido arquivoFechavelRapido = new ArquivoFechavelRapido()){//Recursos são fechados na ordem inversa de criacao
			
			System.out.println("########## ORDEM DE FECHAMENTO ##########");
		}catch(Exception exception){
			
		}
		
		
		
	}

	private static void ordemTryCatchFinally() {
		
		//Primeiro é executado tudo dentro do try
		//Em Segundo lugar é executado tudo dentro do metodo close do recurso
		//Em terceiro é executado o catch se ocorrer alguma exceção 
		//E por ultimo e sempre o finally é executado 
		try(ArquivoAutoFechavel arquivoAutoFechavel = new ArquivoAutoFechavel()) {
			System.out.println("########## ORDEM DOS COMANDOS ##########");
			System.out.println("Bloco TRY");
			throw new IllegalArgumentException("Mensagem Lançada Pelo Try");
		} catch (Exception e) {
			//Consegue capturar a IllegalArgumentException lancada pelo try e dentro dela uma excecao suprimida
			//que foi lançada pelo metodo close do recurso
			System.out.println("Exception Suprimida: " + e.getSuppressed()[0]);
			System.out.println("Bloco CATCH");
		}finally{
			System.out.println("Bloco FINALLY");
			throw new ArrayIndexOutOfBoundsException("Mensagem Lançada Pelo Finally");
		}
	}
}
