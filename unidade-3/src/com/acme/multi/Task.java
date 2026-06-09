package com.acme.multi;

import java.util.*;

public class Task extends Thread {
    private int id;
    private int[] executions;
    
    public Task(int id, int[] executions) {
        this.id = id;
        this.executions = executions;
    }
    
    @Override
    public void run() {
        System.out.println("Task t"+id+ " running...");
        while(true) {
            try {
                executions[id] = executions[id] + 1;
                int t = new Random().nextInt(50, 100);
                Thread.sleep( t );
            } catch (InterruptedException ex) {
                System.getLogger(Task.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
    
}
