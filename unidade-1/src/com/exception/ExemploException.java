package com.exception;
import java.sql.SQLException;

public class ExemploException {

    public static void main(String[] args) {
        try {
            String dia = args[0];
            System.out.println(dia.length());
            
            String s = null;
            s.length();

            String mes = args[1];
            System.out.println(mes.length());

            System.out.println("Fim");
        }catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Falta informar param 2");
        }catch(NullPointerException ex) {
            System.out.println("Ref nula não pode ser");
        }
        System.out.println("segue execução...");
        
        try { 
            calcular(10, 0);
        } catch(ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("fim fo main");
    }
     public static void calcular(int a, int b) throws ArithmeticException {
         if (b == 0) {
             String msg = "Denominador não pode ser zero!";
             ArithmeticException ex = new ArithmeticException(msg);
             
             throw ex;
         }
         System.out.println(a/b);
     }
     
     public static void openConnection() throws SQLException{
         // não faz nada
     }
}
