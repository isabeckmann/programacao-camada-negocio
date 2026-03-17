package com.acme;

import java.util.ArrayList;

public class LocalVar {
    public static void main(String[] args) {
        var nome = "João";
        var idade = 25;

        System.out.println(nome);
        System.out.println(idade);

        var numeros = new ArrayList<Integer>();
        numeros.add(10);
        numeros.add(20);

        System.out.println(numeros);
    }
    
}
