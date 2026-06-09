package com.acme.multi;

import java.util.*;
import java.lang.Runnable;

public class AsyncApp {
    private static final List<String> list = new ArrayList();
    
    public static void main(String[] args) {
        Thread t1 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                list.add("A");
            }
        });
        t1.start();
        
        Thread t2 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                list.add("B");
            }
        });
        t2.start();
        
        Thread t3 = new Thread( new Runnable(){
        
            @Override
            public void run() {
                list.add("C");
            }
        });
        t3.start();
    }
    
}
