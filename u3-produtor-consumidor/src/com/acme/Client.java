package com.acme;

public class Client extends Thread {
    private String name;
    private static final int DOC_SEND = 10;
    
    public Client(String name) {
        this.name = name;
    }
}
