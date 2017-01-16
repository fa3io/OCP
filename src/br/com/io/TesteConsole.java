package br.com.io;

import java.io.Console;

public class TesteConsole {

	public static void main(String[] args) {
	
		Console console = System.console(); 
		
		String id = console.readLine("%s", "Enter UserId:"); //1   
		System.out.println("userid is " + id); //2   
		char[] pwd = console.readPassword("%s", "Enter Password :"); //3   
		System.out.println("password is " + pwd); //4
		
	}
	

}
