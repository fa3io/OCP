package br.com.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class TesteEntrada {

	public static void main(String[] args) {

		
			// fluxos de entrada (InputStream)
			// fluxos de saída (OutputStream)

			// classes abstratas InputStream e OutputStream
			// classe abstrata Reader Manipula arquivos
			// A classe BufferedReader é um Reader

			
		// Lendo de Arquivo
		try(InputStream fileInputStream = new FileInputStream("Arquivos/Arquivo.txt")) {

			// Lendo da entrada Padrão
			 InputStream InputStream = System.in;

			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
			
			

			while (linha != null) {
				System.out.println(linha);
				linha = bufferedReader.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
