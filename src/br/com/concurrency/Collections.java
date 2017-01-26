package br.com.concurrency;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {
	
	
	
	
	public static void main(String[] args) {
		
		 //N�o se pode incluir nullo nem na chave e nem no valor 
		 ConcurrentMap<String, Object> concurrentMap = new ConcurrentHashMap<>();
		 
		 String key = "Fabio";
		 String key1 = "lahis";
		 String fabio = "Fabio Santos Alves"; 
		 String lahis = "Lahis De Senne Pizano"; 
		 String luiz = "Luiz Silva Alves";
		 
		 /**
		  * verificar se a chave j� est� associada a um valor.
		  *  - Se ja associada n�o faz nada e retorna o valor j� associado.
		  *  - Se nao associada associa e retorna null
		  */
		 Object retorno = concurrentMap.putIfAbsent(key, fabio);
		 
		 System.out.println("Contem na chave: " + concurrentMap.get(key));
		 System.out.println("Retorno do putIfAbsent: " + retorno);
		 
		 retorno = concurrentMap.putIfAbsent(key, lahis);//tentando sobreescrever a chave com Lahis
		 
		 System.out.println("Contem na chave: " + concurrentMap.get(key));
		 System.out.println("Retorno do putIfAbsent: " + retorno.toString());
		 
		 /**
		  * Remove apenas se a chave estiver associada ao valor passado
		  * retorna TRUE se foi excluido
		  */
		 boolean removeu = concurrentMap.remove(key, lahis);
		 System.out.println("Removeu? " + removeu);
		 
		 removeu = concurrentMap.remove(key, fabio);
		 System.out.println("Removeu? " + removeu);
		 
		 
		 concurrentMap.putIfAbsent(key, fabio);//Inserindo novamente 
		 
		 
		 
		 /**
		  * Substitui o valor antigo somente se o mesmo est� mapeado para a chave passada
		  * retorna TRUE se foi Substituido
		  * 
		  */
		 boolean trocou = concurrentMap.replace(key, luiz, lahis);
		 System.out.println("Substituiu ? " + trocou);
		 
		 trocou = concurrentMap.replace(key, fabio, lahis);
		 System.out.println("Substituiu ? " + trocou);
		 
		 
		 /**
		  * Substituiu o valor apenas se a chave estiver mapeada para qualquer objeto
		  * Retorna a chave antiga associada ou null e se nenhuma chave associada ou tiver null associado 
		  */
		 Object substituiu = concurrentMap.replace(key1, fabio);
		 System.out.println("Substituiu ? " + substituiu);
		 
		 substituiu = concurrentMap.replace(key, fabio);
		 System.out.println("Substituiu ? " + substituiu);
		 
		 
		 
		 
		 
		 /**
		  * 
		  * Classe CopyOnWriteArrayList<E>
		  * 
		  * Uma variante thread-safe do ArrayList em que todas as opera��es mutativas (add, set e assim por diante) Uma nova c�pia da matriz subjacente.
		  * O m�todo de iterador de estilo "instant�neo" usa uma refer�ncia ao estado da matriz no ponto em que o iterador foi criado. 
		  * Esta matriz nunca muda durante a vida �til do iterador, portanto, a interfer�ncia � imposs�vel eo iterador � garantido para n�o jogar
		  *  ConcurrentModificationException. 
		  *  O iterador n�o ir� refletir adi��es, remo��es ou altera��es na lista desde que o iterador foi criado. 
		  *  As opera��es de altera��o de elementos nos pr�prios iteradores (remover, definir e adicionar) n�o s�o suportadas. 
		  *  Esses m�todos lan�ar UnsupportedOperationException
		  *  
		  *  Pode-se incluir nulo nos elementos
		  * 
		  */
		 
		 List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
