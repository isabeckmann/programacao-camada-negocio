package com.bank.account;

// TestaBankAccount.java
public class TestaBankAccount {
    public static void main(String[] args) {
        // Criando conta e cliente
        Account cc = new Account("001-X", 12345, 500.0f);
        Costumer cliente = new Costumer("João Silva", "123.456.789-00", "01/01/1990");
        
        cliente.addAccount(cc);

        try {
            System.out.println("--- Testando Depósito Positivo ---");
            cc.put(200.0f);
            
            System.out.println("--- Testando Saque Excessivo ---");
            cc.take(1000.0f); // Deve lançar exceção
            
        } catch (AccountOperationException e) {
            System.err.println("Erro na operação: " + e.getMessage());
        }

        try {
            System.out.println("\n--- Testando Depósito Negativo ---");
            cc.put(-50.0f); // Deve lançar exceção
            
        } catch (AccountOperationException e) {
            System.err.println("Erro na operação: " + e.getMessage());
        }

        try {
            System.out.println("\n--- Testando Remoção de Conta Inexistente ---");
            cliente.removeAccount("999-9", 0000); // Deve lançar exceção
            
        } catch (AccountOperationException e) {
            System.err.println("Erro na operação: " + e.getMessage());
        }

        System.out.println("\n--- Estado Final ---");
        cliente.printAccounts();
    }
}
