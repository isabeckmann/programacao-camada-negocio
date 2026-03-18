package com.acme.bank;

public class TestBankAccount {

    public static void main(String[] args) {
        Account a1 = new Account();
        Customer c1 = new Customer();
        c1.addAccount(a1);
    }
    
}
