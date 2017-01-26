package br.com.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UsandoLock {
	
	public static void main(String[] args) {
		
		
		/**
		 * Classe lock sincroniza explicitamente um trecho de codigo é necessario efetuar fazer o unlock()
		 */
		ReentrantLock reentrantLock = new ReentrantLock();
		
		reentrantLock.lock();//Obtem o bloqueio 
		
		/**
		 * Adquire o bloqueio somente se estiver livre no momento da invocação
		 * Retorna TRUE se o bloqueio foi adquirido se nao FALSE
		 */
		boolean f2 = reentrantLock.tryLock();
		System.out.println(f2); 
		
		boolean f3 = reentrantLock.tryLock();
		System.out.println(f3); 
		
		/**Efetua a liberacao do bloqueio */
		reentrantLock.unlock();
		
		/** Adiquiri uma condcao para ser usada no lock */
		Condition condition = reentrantLock.newCondition();
		
		
		/**
		 * Classe para Locar Leitura e escrita
		 * Se uma thread locar para leitura outras podem ler mas não escrever
		 * Se uma thread locar para escrita nenhuma thread poderá ler nem escrever 
		 */
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		
		//Efetuado lock(Bloqueio) para leitura
		readWriteLock.readLock().lock();
		
		//Efetuando unlock(desbloqueio) para leitura
		readWriteLock.readLock().unlock();
		
		//Efetuado lock(Bloqueio) para Escrita
		readWriteLock.writeLock().lock();
		
		//Efetuando unlock(desbloqueio) para escrita
		readWriteLock.writeLock().unlock();
	}

}
