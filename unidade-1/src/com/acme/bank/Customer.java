package com.acme.bank;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private String name;
    private String CPF;
    private Date birthDate;
    private ArrayList<Account> bankAccounts;
    
    //Construtor
    public Customer(String name, String CPF, Date birthDate) {
        this.name = name;
        this.CPF = CPF;
        this.birthDate = birthDate;
        bankAccounts = new ArrayList();
    }
    
    public Customer() {
        this("", "", null);
    }
    
    public void addAccount() {

    }
}


