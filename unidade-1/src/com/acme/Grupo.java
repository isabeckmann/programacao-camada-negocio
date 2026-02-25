package com.acme;
import java.util.ArrayList;
public class Grupo {
    ArrayList<Aluno> data = new ArrayList();
    
    public Aluno get(int i) {
        return data.get(i);
    }
    
    public void add(Aluno a) {
        data.add(a);
    }
}
