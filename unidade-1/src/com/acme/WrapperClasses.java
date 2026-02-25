package com.acme;

public class WrapperClasses {

    public static void main(String[] args) {
        //int x = 10; //primitivo
        
        //Integer i = new integer(20); //objeto
        //short s = i.shortValue();
        
        String t = "45";
        int a = Integer.parseInt(t); //wrapper classes oferecem operações de instâncias 
        System.out.println("to binary:");
        System.out.println(Integer.toBinaryString(4));
        
        byte z = 127;
        System.out.println(z);
        
        byte y = (byte)200; //transforma em byte de 8bits
        System.out.println(y);
        
        //Classes mostram os métodos 
        
        Integer i = 20;
        int p = i + 4;
        System.out.println(p);
        
        //todas wrapper classes tem construtores como Integer(int) e Integer(String)
    }
    
}
