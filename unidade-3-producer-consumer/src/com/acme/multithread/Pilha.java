package com.acme.multithread;

/**
 * Esta classe representa uma pilha. Possui um metodo para adicionar um objeto e outro para remover.
 * @author: Rafael Zancan Frantz
 */
public class Pilha {

    private int topo;  // Variavel de instancia compartilhada pelos metodos setTopo() e getTopo.
    private int[] data;   // Variavel de instancia compartilhada pelos metodos setTopo() e getTopo.

    /**
     * Construtor para a classe Pilha.Recebe o tamanho da pilha como parametro.
     * @param tamanho tamanho da pilha
     */
    public Pilha(int tamanho) {
        data = new int[tamanho];
    }

    /**
     * Metodo para retirar o elemento do topo da pilha.
     * @return int representando o objeto no topo da pilha
     */
    public synchronized int getTopo() {
        while (topo == 0) {
            try {
                System.out.println("Pilha vazia! Topo=" + topo + " ---> wait() para:" + Thread.currentThread().getName());
                this.wait();
                System.out.println(Thread.currentThread().getName() + " sai do wait()");
            } catch (InterruptedException ignored) {}
        }

        topo--;

        System.out.println("Removido:   " + data[topo] + " --> posicao: " + topo);
        this.notify();
        return data[topo];
    }

    
    
    /**
     * Adiciona um objeto no topo da lista.
     *
     * @param obj objeto a ser adicionado no topo da pilha
     */
    public synchronized void setTopo(int obj) {

        while (topo == data.length) {
            try {
                System.out.println("Pilha cheia! Topo=" + topo + " ---> wait() para: " + Thread.currentThread().getName());
                this.wait();
                System.out.println(Thread.currentThread().getName() + " sai do wait()");
            } catch (InterruptedException ignored) {}
        }

        System.out.println("Adicionado: " + obj + " --> posicao: " + topo);
        data[topo] = obj;
        topo++;
        this.notify();
    }
}
