package com.acme;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ExemploCollections {

    public static void main(String[] args) {
        List<String> lista = new LinkedList();
        lista.add("João");
        lista.add("Marcos");
        lista.add("Julia");
        lista.add("Bob");
        lista.add("Carla");
        
        //Collections.reverse(lista);
        //Collections.shuffle(lista);
        foo(lista);
        
        HashSet h = new HashSet();
        //foo(h);
        
    }
    private static void foo(List<String> list) {
        for(String s: list) {
            System.out.println(s);
        }
    }
}
