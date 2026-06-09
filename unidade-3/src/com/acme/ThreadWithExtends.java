package com.acme;

class Task extends Thread {
    
    private char character;
    
    public Task(char c){
        character = c;
    }

    @Override
    public void run() {
        
        while (true){            
            try {
                System.out.print(character);
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {}
            
        }
        
    } 
    
}


public class ThreadWithExtends {
    
    public static void main(String[] args) {
        Thread t1 = new Task('O');
        t1.start();
        t1.setPriority( Thread.MAX_PRIORITY );
        
        Thread t2 = new Task('.');
        t2.start();
        t2.setPriority( Thread.MIN_PRIORITY );
    }
}
