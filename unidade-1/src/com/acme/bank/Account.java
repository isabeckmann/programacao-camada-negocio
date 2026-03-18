package com.acme.bank;

public class Account {
    private float balance;
    private String branchOffice;
    private int num;
    private boolean active;
    
    //operações 
    public void take(float amount) throws BankAccountException {
        if(balance - amount <= 0) {
            String msg = "operação de saque não pode ser realizada. valor sacado é superior ao saldo da conta";
            throw new BankAccountException(msg);
        }
        
        balance = balance - amount;
    }
    
    public void put(float amount) throws BankAccountException {
        if(amount <= 0) {
            String msg = "Valor inválido";
            throw new BankAccountException(msg);
        }
        
        balance = balance + amount;
    }
    
    public String getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
