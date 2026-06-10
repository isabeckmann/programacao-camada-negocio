package com.acme.multi;

import java.util.*;
import java.lang.Runnable;

public class AsyncApp {
    private static final List<String> list;
    private static final int QUANTIDADE = 100;
    
    static {
        //list = new ArrayList();
        //quando usa essa synchronizedList não precisa usar o dentro do for
        list = Collections.synchronizedList(new ArrayList());
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                for (int i=0; i<QUANTIDADE; i++) {
                    //synchronized (list) {
                        list.add("A");
                    //}
                }
            }
        });
        
        Thread t2 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                for (int i=0; i<QUANTIDADE; i++) {
                    //synchronized (list) {
                        list.add("B");
                    //}
                }
            }
        });
        
        Thread t3 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                for (int i=0; i<QUANTIDADE; i++) {
                    //synchronized (list) {
                        list.add("C");
                    //}
                }
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException interruptedException) {
        }
        
        for(String s: list) {
            System.out.println(s);
        }
        System.out.println("Size --> "+list.size());
    }
    
}
