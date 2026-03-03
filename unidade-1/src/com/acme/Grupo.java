package com.acme;
import java.util.ArrayList;
public class Grupo<T> {
    ArrayList<T> data = new ArrayList();
    
    public T get(int i) {
        return data.get(i);
    }
    
    public void add(T a) {
        data.add(a);
    }
}
