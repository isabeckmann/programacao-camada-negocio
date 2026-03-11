package com.estatico;

public class TesteEmpregado {

    public static void main(String[] args) {
        Empregado emp1 = new Empregado();
        emp1.setNome("Zoe");
        System.out.println(emp1.getNome() + " --> " + emp1.getSalario());
        System.out.println(Empregado.salarioBase);
        
        Empregado emp2 = new Empregado();
        emp2.setNome("Sebastião");
        System.out.println(emp2.getNome() + " --> " + emp2.getSalario());
    }
    
}
