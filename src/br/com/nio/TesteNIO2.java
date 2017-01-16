package br.com.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteNIO2 {

	public static void main(String[] args){

		Path path = Paths.get("Arquivos/NIO.txt");

		Charset utf8 = StandardCharsets.UTF_8;

		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, utf8)){
			bufferedWriter.write("Estudando...\n");
			bufferedWriter.write("OCP - Oracle Certified Professional, Java SE 7 \n");
			bufferedWriter.write("Rumo a Madrugada!!!");
			bufferedWriter.flush();
			bufferedWriter.close();
			
			
			
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		try(BufferedReader bufferedReader = Files.newBufferedReader(path, utf8)){
			
			String linha = null;
			
			while ((linha = bufferedReader.readLine()) != null) {
				System.out.println(linha);
			}
			
		}catch (Exception e) {
		System.out.println("Erro: "+ e.getMessage());
		}


	}

}
