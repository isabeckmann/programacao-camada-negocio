package com.acme.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorApp {
    // Ao aumentar o número de threads, o tempo diminui
    // 5 threads = 101.080ms
    // 15 threads = 34.036ms
    // 25 threads = 21.023ms
    // 50 threads = 11.026ms
    
    private static final int NUMBER_OF_THREADS_IN_POOL = 50;
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS_IN_POOL, new MyThreadFactory());
        
        long start = System.currentTimeMillis();
        for (int i=0; i<5_000; i++) {
            Task t = new Task(i);
            executor.submit(t);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("Tempo total de processamento = "+ (end-start));
        executor.shutdown();
        
        while ( !executor.isTerminated()) {
            System.out.println("Aguardando finalização das threads pendentes...");
            try {
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
        
        long end2 = System.currentTimeMillis();
        
        System.out.println("Todas as tarefas foram executadas!");
        System.out.println("Tempo total: "+ (end2 - start));
    }
}
