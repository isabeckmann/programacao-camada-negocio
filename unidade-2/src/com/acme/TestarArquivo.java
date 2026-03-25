package com.acme;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestarArquivo {

    public static void main(String[] args) {
        /*Usuario u1 = new Usuario("Maria", "123");
        Usuario u2 = new Usuario("Joao", "456");
        Usuario u3 = new Usuario("Jose", "789");
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        
        persistir("usuarios.dat", usuarios);*/
        
        List<Usuario> usuarios = carregar("usuarios.dat");
        
        usuarios.forEach(usuario -> System.out.println(usuario.getNome() + ":" + usuario.getDataCriacao()));
    }
    
    private static void persistir(String arquivo, ArrayList<Usuario> usuarios) {
        try (FileOutputStream fos = new FileOutputStream(arquivo)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(usuarios);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static List<Usuario> carregar(String arquivo) {
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                return (List<Usuario>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
