package com.acme;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestarTexto {

    public static void main(String[] args) {
       try {
           FileReader fr = new FileReader("ipsum.txt");
           BufferedReader br = new BufferedReader(fr);
           StringBuffer buffer = new StringBuffer();
           String line;
           
           while((line = br.readLine()) != null) {
               buffer.append(line);
               buffer.append("\n");
           }
           
           fr.close();
           br.close();
           
           System.out.println(buffer.toString());
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
    }
}
