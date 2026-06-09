package com.acme.multi;

public class StartApp {

    public static void main(String[] args) {
        int[] executions = new int[3];
        
        Thread t0 = new Task(0, executions);
        Thread t1 = new Task(1, executions);
        Thread t2 = new Task(2, executions);
        
        t0.start();
        t0.setPriority(1);
        
        t1.start();
        t1.setPriority(10);
        
        t2.start();
        t2.setPriority(10);
        
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException interruptedExecution){}
        
        System.out.println("Thread 0 -> "+executions[0]);
        System.out.println("Thread 1 -> "+executions[1]);
        System.out.println("Thread 2 -> "+executions[2]);
    }
    
}
