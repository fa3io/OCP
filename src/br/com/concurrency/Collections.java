package br.com.concurrency;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {
	
	
	
	
	public static void main(String[] args) {
		
		 //Não se pode incluir nullo nem na chave e nem no valor 
		 ConcurrentMap<String, Object> concurrentMap = new ConcurrentHashMap<>();
		 
		 String key = "Fabio";
		 String key1 = "lahis";
		 String fabio = "Fabio Santos Alves"; 
		 String lahis = "Lahis De Senne Pizano"; 
		 String luiz = "Luiz Silva Alves";
		 
		 /**
		  * verificar se a chave já está associada a um valor.
		  *  - Se ja associada não faz nada e retorna o valor já associado.
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
		  * Substitui o valor antigo somente se o mesmo está mapeado para a chave passada
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
		  * Uma variante thread-safe do ArrayList em que todas as operações mutativas (add, set e assim por diante) Uma nova cópia da matriz subjacente.
		  * O método de iterador de estilo "instantâneo" usa uma referência ao estado da matriz no ponto em que o iterador foi criado. 
		  * Esta matriz nunca muda durante a vida útil do iterador, portanto, a interferência é impossível eo iterador é garantido para não jogar
		  *  ConcurrentModificationException. 
		  *  O iterador não irá refletir adições, remoções ou alterações na lista desde que o iterador foi criado. 
		  *  As operações de alteração de elementos nos próprios iteradores (remover, definir e adicionar) não são suportadas. 
		  *  Esses métodos lançar UnsupportedOperationException
		  *  
		  *  Pode-se incluir nulo nos elementos
		  * 
		  */
		 
		 List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
