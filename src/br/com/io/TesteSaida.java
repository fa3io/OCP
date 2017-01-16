package br.com.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteSaida {

	// fluxos de entrada (InputStream)
	// fluxos de saída (OutputStream)
	// classes abstratas InputStream e OutputStream

	public static void main(String[] args) throws IOException {

		try(OutputStream fileOutputStream = new FileOutputStream("Arquivos/Arquivo.txt",Boolean.TRUE)) {
			
			OutputStreamWriter outpuStreamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outpuStreamWriter);

			bufferedWriter.write("OCP - Oracle Certified Professional, Java SE 7\n");

			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
