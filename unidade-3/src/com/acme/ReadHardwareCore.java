package com.acme;

public class ReadHardwareCore {

    public static void main(String[] args) {
        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("Núcleos lógicos = "+ nucleos);
    }
    
}
