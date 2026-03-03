package com.acme;

public class ExemploVarargs {

    public static void main(String[] args) {
        //quando chama o String[] names
        String[] alunos = new String[5];
        alunos[0] = "Márcia";
        alunos[1] = "Pedro";
        alunos[2] = "Julia";
        alunos[3] = "Luiza";
        alunos[4] = "Isadora";
        
        foo(alunos);
        
        //quando só usa os ...
        foo("Rafael", "Pedro", "Alice");
        foo("Isadora", "Julia", "Bruna", "Luiza");
        foo("João");
        foo();
    }
    
    //dessa forma é obrigado a criar o vetor
    //public static void foo(String[] names) {
        //for(String s: names) {
            //System.out.println(s.length());
        //}
    //}
    
    //assim não é necessário, é só colocar no foo
    public static void foo(String... names) {
        for(String s: names) {
            System.out.println(s.length());
        }
    }
    
}
