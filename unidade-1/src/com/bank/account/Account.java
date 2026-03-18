package com.bank.account;

public class Account {
    private float balance;
    private String branchOffice;
    private int number;
    private boolean active;

    public Account(String branchOffice, int number, float initialBalance) {
        this.branchOffice = branchOffice;
        this.number = number;
        this.balance = initialBalance;
        this.active = true;
    }

    // Getters para identificação da conta
    public String getBranchOffice() { return branchOffice; }
    public int getNumber() { return number; }
    public float getBalance() { return balance; }

    public void take(float amount) throws AccountOperationException {
        // Erro se não houver saldo suficiente [cite: 18, 31]
        if (amount > balance) {
            throw new AccountOperationException("Saldo insuficiente para o saque.");
        }
        balance -= amount;
    }

    public void put(float amount) throws AccountOperationException {
        // Erro se o valor for negativo [cite: 20, 29]
        if (amount < 0) {
            throw new AccountOperationException("Não é possível depositar valores negativos.");
        }
        balance += amount;
    }
}
