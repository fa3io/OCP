package br.com.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteNIO {

	public static void main(String[] args) throws IOException {

		//Caminho de onde está o arquivo ou pasta
		//Não é obrigado a existir
		Path path = Paths.get("Arquivos/NIO.txt");
		
		System.out.println(path.toAbsolutePath());
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
		System.out.println(path.getFileName());
		System.out.println(path.getFileSystem());


		//Cria o Diretorio
		Files.createDirectories(path.getParent());
		
		
		byte[] bytes = "OCP - Oracle Certified Professional, Java SE 7".getBytes();
		
		//Grava um array de bytes no caminho
		Files.write(path, bytes); // Cria se não existir , Limpa e escreve
		
		byte[] readAllBytes = Files.readAllBytes(path);
		
		System.out.println(new String(readAllBytes));
		
	}

}
