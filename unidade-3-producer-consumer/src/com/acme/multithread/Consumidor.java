package com.acme.multithread;

/**
 * Esta classe representa um comsumidor que irá retirar elementos da de uma Pilha
 *
 * @author: Rafael Zancan Frantz
 */
public class Consumidor extends Thread {

    Pilha pilha; // Variável de instância que possui uma referencia para a pilha criada pelo Gerente

    /**
     * Contrutor para o Consumidor.
     *
     * @param p Pilha
     */
    public Consumidor(Pilha p) {
        pilha = p;
    }

    @Override
    public void run() {

        while (true) {

            /**
             * Se a pilha não estiver sendo acessada por outra thread
             * (bloqueada), então retira o número que está no seu topo.
             */
            int n = pilha.getTopo();

            /**
             * Após retirar o elemento da pilha, a Thread corrente, ou seja, a
             * Thread consumidor será forçada a dormir por alguns
             * milisegundos (determinados aleatoriamente).
             */
            try {
                Thread.sleep(Math.round(new Float(Math.random() * 10000)));
            } catch (InterruptedException ignored) {}

        }
    }
}
