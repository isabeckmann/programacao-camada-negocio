package com.bank.account;

import java.util.ArrayList;
import java.util.List;

public class Costumer {
    private String name;
    private String cpf;
    private String birthdate;
    private List<Account> bankAccounts;

    public Costumer(String name, String cpf, String birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.bankAccounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.bankAccounts.add(account);
    }

    public void removeAccount(String branchOffice, int number) throws AccountOperationException {
        Account accountToRemove = null;
        for (Account acc : bankAccounts) {
            if (acc.getBranchOffice().equals(branchOffice) && acc.getNumber() == number) {
                accountToRemove = acc;
                break;
            }
        }

        // Erro se a conta não for encontrada [cite: 22, 32]
        if (accountToRemove == null) {
            throw new AccountOperationException("Conta não encontrada para remoção.");
        }
        bankAccounts.remove(accountToRemove);
    }

    public void printAccounts() {
        System.out.println("Cliente: " + name + " (CPF: " + cpf + ")");
        for (Account acc : bankAccounts) {
            System.out.println("- Agência: " + acc.getBranchOffice() + " | Nº: " + acc.getNumber() + " | Saldo: " + acc.getBalance());
        }
    }
}
