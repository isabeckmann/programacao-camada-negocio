package com.estatico;

public class Empregado {
    private String nome;
    private float salario;
    public static float salarioBase;
    
    static {
        salarioBase = 5000f;
        System.out.println("Bytecode de classe Empregado carregado com sucesso");
    }

    public Empregado() {
        System.out.println("Objeto sendo criado");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
