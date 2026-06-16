package com.acme.multithread;

import java.util.Random;

public class Produtor extends Thread {

    private Pilha pilha; // Variável de instância que representara um ponteiro para a pilha compartilhada	

    /**
     * Construtor para a classe Produtor. Recebe uma pilha.
     *
     * @param p Pilha
     */
    public Produtor(Pilha p) {
        pilha = p;
    }

    
    
    @Override
    public void run() {
        Random r = new Random(100);
        while (true) {

            /**
             * Se a pilha não estiver sendo utilizada por outra Thread
             * (bloqueada) então será requerido o seu sinalizador de bloqueio
             * para que a Thread Produtor possa inserir um número
             * randômico no seu topo.
             */
            int n = r.nextInt(9);
            pilha.setTopo(n);

            /**
             * Após adicionar o elemento no topo da pilha, a Thread produtor será forçada a dormir por alguns
             * milisegundos (definidos aleatoriamente).
             */
            try {
                Thread.sleep(Math.round((Math.random() * 10000)));
            } catch (InterruptedException ignored) {}

        }
    }
}
