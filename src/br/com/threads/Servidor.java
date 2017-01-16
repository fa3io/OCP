package br.com.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {
		final ServerSocket servidor = new ServerSocket(12345);
		Runnable runnnable;
		
		while (true) {
		runnnable = new Runnable() {
			@Override
			public void run() {
				try {
				Socket cliente = servidor.accept();
				Scanner s = new Scanner(cliente.getInputStream());
				while (s.hasNextLine()) {
					System.out.println(s.nextLine());
				}
				s.close();	
				} catch (IOException e) {
				}
			}
		};
			
		}
	}
}
