package com.acme;

public class RunGrupo {

    public static void main(String[] args) {
        Grupo g1 = new Grupo();
        g1.add(new Aluno()); //gustavo
        g1.add(new Aluno()); //ana
        
        Grupo g2 = new Grupo();
        g2.add(new Aluno()); //pedro
        g2.add(new Aluno()); //isadora
        
        Grupo g3 = new Grupo();
        g3.add(new Professor());
    }
    
}
