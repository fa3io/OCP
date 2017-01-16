package br.com.threads;

import java.io.FileReader;
import java.util.Properties;

public class PrincipalException {

    static Properties p1;
    static Properties p2;
    static Properties p3;
    

	
	public static void main(String[] args) {
		
	    Thread.UncaughtExceptionHandler handler = new  Thread.UncaughtExceptionHandler() {
	    	@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Erro tratado");
			}
		};
		
       Thread leitor1 =  new Thread(new LeitorPropriedades(p1, "arquivo1.txt"));
       Thread leitor2 =  new Thread(new LeitorPropriedades(p2, "arquivo2.txt"));
       Thread leitor3 =  new Thread(new LeitorPropriedades(p3, "arquivo3.txt"));
        
        
        leitor1.setUncaughtExceptionHandler(handler);
        leitor2.setUncaughtExceptionHandler(handler);
        leitor3.setUncaughtExceptionHandler(handler);
        
        leitor1.start();
        leitor2.start();
        leitor3.start();
        
    }
}

class LeitorPropriedades implements Runnable {

    private Properties p;
    private String nomeArquivo;

    public LeitorPropriedades(Properties p, String nomeArquivo) {
        this.p = p;
        this.nomeArquivo = nomeArquivo;
    }

    public void run() {
        try {
            p.load(new FileReader(nomeArquivo));
        } catch (Exception e) {
        	  throw new RuntimeException(e);
        }
    }
}