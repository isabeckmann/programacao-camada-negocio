package com.acme.bank;

public class BankAccountException extends RuntimeException {
    public BankAccountException(String msg) {
        super(msg); //se abre parenteses ele chama o construtor
    }
}
