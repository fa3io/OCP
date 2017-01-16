package br.com.threads;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades implements Runnable {
	
	private String nome;
	private String path;
	
	public Propriedades(String nome, String path) {
		this.nome = nome;
		this.path = path;
	}

	@Override
	public void run() {
		Properties propriedades = new Properties();
		try {
		FileInputStream file = new FileInputStream(path);
			propriedades.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Object item : propriedades.values()) {
			System.out.println(nome +" - "+ item);
		}
		
	}
}
