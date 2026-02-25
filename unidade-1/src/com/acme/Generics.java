package com.acme;
import java.util.ArrayList;

public class Generics {
    //o main é estático, então para chamar outra, precisa ser estático também
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList(); //é genérico, então não limita o tipo de dado, então existe a possibilidade de add um 
                                                  //valor no vetor que futuramente pode causar problema. 
        list.add("ijuí");
        list.add("panambi");
        //list.add(450);
        
        printData(list);
    }
    
    private static void printData(ArrayList<String> data) { //ao usar <String> não precisa mais de casting pois restringe o tipo
        for (String s : data) {
            System.out.println(s);
        }
        
        // for (int i=0; i<data.size(); i++) {
            //faz um casting pois o retorno do get é objeto e não uma string
        //    String s = (String)data.get(i);
        //    System.out.println(s.length());
        //}
    }
}
