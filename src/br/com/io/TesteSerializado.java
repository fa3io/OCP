package br.com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class animal{
	String nome;
	
	public animal() {
		nome = "Luiz";
	}
}

class Mamifero extends animal implements Serializable{
	Integer idade;
	public Mamifero() {
		idade = 40;
	}
}

class Pessoa extends Mamifero{
	String comunicacao;
	
	public Pessoa() {
		comunicacao = "Fraca";
	}
}

public class TesteSerializado {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream  objectOutputStream = new ObjectOutputStream(new FileOutputStream("Arquivos/Serializado"));
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.nome = "Fabio";
		pessoa.idade = 25;
		pessoa.comunicacao ="Forte"; 
		
		objectOutputStream.writeObject(pessoa);
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Arquivos/Serializado"));
		
		Pessoa pessoa2 = (Pessoa) objectInputStream.readObject();
		
		objectInputStream.close();
		
		
		System.out.println(pessoa2.nome);
		System.out.println(pessoa2.idade);
		System.out.println(pessoa2.comunicacao);
		
	}

}
