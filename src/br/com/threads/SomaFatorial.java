package br.com.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SomaFatorial {

    public static void main(String[] args) throws Exception{
        BlockingQueue<Long> queue = new ArrayBlockingQueue<>(3);
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(new FatorialBlockingQueue(16L,queue));
        ex.execute(new FatorialBlockingQueue(7L,queue));
        ex.execute(new FatorialBlockingQueue(12L,queue));

        Long total = queue.take() + queue.take() + queue.take();

        System.out.println(total);
    }
}

class FatorialBlockingQueue implements Runnable {
    private Long numero;
    private BlockingQueue<Long> queue;
    public FatorialBlockingQueue(Long numero, BlockingQueue<Long> queue) {
        this.numero = numero;
        this.queue = queue;
    }
    public void run(){
        Long resultado = 1L;
        for(Long i=numero; i>1; i--){
            resultado *= i;
        }
        try {
            queue.put(resultado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}