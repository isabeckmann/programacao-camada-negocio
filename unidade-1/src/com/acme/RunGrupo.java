package com.acme;

public class RunGrupo {

    public static void main(String[] args) {
        //ao adicionar o T em Grupo.java, é possível generalizar os grupos para posteriormente especificar
        //utilizando <Aluno> ou <Professor>
        Grupo<Aluno> g1 = new Grupo();
        g1.add(new Aluno()); //gustavo
        g1.add(new Aluno()); //ana
        
        Grupo<Aluno> g2 = new Grupo();
        g2.add(new Aluno()); //pedro
        g2.add(new Aluno()); //isadora
        
        Grupo<Professor> g3 = new Grupo();
        g3.add(new Professor());
        
        foo(g1);
        foo(g2);
    }
    
    private static void foo(Grupo g) {
        //for (Aluno a: g) {
            //System.out.println("");
        //}
    }
}
