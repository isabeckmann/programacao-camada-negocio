package com.acme.executor;

import java.util.Random;

public class Task implements Runnable {
    private int number;
    
    public Task(int n) {
        number = n;
    }
    
    @Override
    public void run() {
        //Algoritmo de procssamento de cada tarefa
        System.out.printf("Ação da tarefa %d executada com sucesso. \n", number);
        
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(50, 150));
        } catch(Exception ex) {
            
        }
    }
}
