package com.enumeration;

public class TesteEnum {

    public static void main(String[] args) {

        registrarEncomenda("Ana", StatusPedido.ENTREGUE);
        registrarEncomenda("Julia", StatusPedido.ENVIADO);

    }
    
    private static void registrarEncomenda(String nomeCliente, StatusPedido s) {
        System.out.println(nomeCliente + " --> " + s.name());
        System.out.println(s.isFinalizado() ? "Sim" : "Não");
        System.out.println(s.getDescricao());
    }
}