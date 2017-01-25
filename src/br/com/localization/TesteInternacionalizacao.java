package br.com.localization;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TesteInternacionalizacao {
	public static void main(String[] args) {
		/** Temos o seguintes Bundles: 
		 * 
		 * 	messages_en_US.properties
		 *	messages_en.properties
		 *  messages_pt_BR.properties
		 *	messages.properties
		 *
		 *  Se o Bundle especificado não existir que eh o nosso caso  messages_de_DE não existe, o java verifica qual o Locale default 
		 *	no nosso caso settamos enUS como padrao e nos temos o bundle messages_en_US então o mesmo será usado, caso uma chave não seja
		 *	encontrada nele a hierarquia descera para messages_en e no caso de não encontrar tentara achar no messages que eh o default
		 *	se ainda sim nao encontrar teremos uma java.util.MissingResourceException
		 *
		 *  No nosso caso temos a chave prova que existe no messages_pt_BR mas nunca será usada e receberemos um java.util.MissingResourceException
		 */
		Locale deDE = Locale.GERMANY;
		Locale enUS = new Locale("en","US");

		Locale.setDefault(enUS);
		
		ResourceBundle bundle = ResourceBundle.getBundle("messages",deDE);
		
		System.out.println(bundle.getString("welcome")); //Existe em ResourceBundle enUS entao traz corretamente
		System.out.println(bundle.getString("esporte")); //Nao existe em enUS entao desce a hierarquia en 
		System.out.println(bundle.getString("clima")); // Existe apenas no messages default
		System.out.println(bundle.getString("comida"));//Existe no pt_BR e em messages default
		System.out.println(bundle.getString("prova"));//Não existe em lugar nenhum
		
	
		//Estudar mais a classe control
		ResourceBundle bundleControl = ResourceBundle.getBundle("messages", Locale.US, new ResourceBundle.Control() { 
			@Override
			public List<Locale> getCandidateLocales(String baseName, Locale locale) {
				return super.getCandidateLocales(baseName, locale);
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
