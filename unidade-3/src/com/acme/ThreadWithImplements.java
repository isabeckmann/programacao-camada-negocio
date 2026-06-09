package com.acme;

class App {
    
}

class Printer extends App implements Runnable {
    
    private int copies;
    private String doc;
    
    public Printer(int copies, String doc) {
        this.copies = copies;
        this.doc = doc;
    }

    @Override
    public void run() {
        System.out.println("Thread rodando...");
        for (int i=0; i<copies; i++) {
            System.out.println("Printing doc "+doc+" copy #"+i);
        }
    }   
    
}


public class ThreadWithImplements { 
    
    public static void main(String[] args) {
        
        System.out.println("Iniciando o método main...");
        
        Printer p1 = new Printer(5, "myProfile.txt");
        
        Thread t1 = new Thread(p1);
        t1.start();
        
        System.out.println("Going to thread 2...");
        
        Printer p2 = new Printer(10, "ResearchProject.pdf");
        
        Thread t2 = new Thread(p2);
        t2.start();
        
        System.out.println("Finalizando aplicação");
        
    }
    
}

