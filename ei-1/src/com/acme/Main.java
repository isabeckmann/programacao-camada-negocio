package com.acme;

public class Main {

    public static void main(String[] args) {

        Pessoa p = new Pessoa("Isadora", 21);
        Pessoa p2 = new Pessoa("Julia", 22);

        System.out.println("Nome: " + p.name());
        System.out.println("Idade: " + p.age());

        System.out.println("Objeto completo: " + p);

        System.out.println("São iguais? " + p.equals(p2));
    }
}