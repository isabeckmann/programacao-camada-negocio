package com.acme;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestarArquivo {

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Maria", "123");
        Usuario u2 = new Usuario("Joao", "456");
        Usuario u3 = new Usuario("Jose", "789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        
        persistir("usuarios.dat", usuarios);
    }
    
    private static void persistir(String arquivo, ArrayList<Usuario> usuarios) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(usuarios);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
