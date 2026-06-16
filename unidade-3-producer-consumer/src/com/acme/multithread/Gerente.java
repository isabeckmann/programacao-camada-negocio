package com.acme.multithread;

/**
 * Classe para criar os dois Threads e inicializa-los.
 *
 * @author: Rafael Zancan Frantz
 */
public class Gerente {

    public static void main(String[] args) {
        
        Pilha p = new Pilha(10);
        
        Thread prod1 = new Produtor(p);
        Thread prod2 = new Produtor(p);
        
        Thread cons = new Consumidor(p);

        // Seta as prioridades.
        prod1.setPriority(10);
        prod2.setPriority(10);
        
        cons.setPriority(10);

        // Seta os nomes dos Threads
        prod1.setName("Thread produtor 1");
        prod2.setName("Thread produtor 2 ");
        cons.setName("Thread consumidor");

        System.out.println("Prioridade Maxima: " + Thread.MAX_PRIORITY);
        System.out.println("Prioridade Minima: " + Thread.MIN_PRIORITY);
        System.out.println("\n\nPrioridade do Produtor: " + prod1.getPriority());
        System.out.println("Prioridade do Consumidor: " + cons.getPriority());
        System.out.println("\n\n");

        prod1.start();
        prod2.start();
        cons.start();

    }
}
