package br.com.exception;

import java.io.Closeable;

class RecursoVideo implements Closeable{
	public RecursoVideo() {System.out.println("Recurso de Video Criado");}
	@Override
	public void close(){
		System.out.println("Fechando Classe Recurso de Video");
	}
}
class RecursoAudio implements AutoCloseable{
	public RecursoAudio() {System.out.println("Recurso de Audio Criado");}
	@Override
	public void close(){
		System.out.println("Fechando Classe Recurso de Audio");
	}
}

public class TryCatch {
	public static void main(String[] args) {
		//try-with-resources abre o recurso e fecha separado por virgula 
		//O recurso deve implementar  java.lang.AutoCloseable ou java.io.Closeable
		//Quando tiver dois recursos ele fecha na ordem inversa da declaração
		//Não é necessario o catch quando usamos para fechar um resource
		try (RecursoAudio recursoAudio = new RecursoAudio();RecursoVideo recursoVideo = new RecursoVideo()) {
			System.out.println("Usando Recursos");
			throw new IllegalArgumentException();
		}catch (Exception erro) {
			System.out.println("Bloco Catch");
		}finally {
			System.out.println("Bloco Finally");
		}
	}
}
