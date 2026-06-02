package com.acme;
import java.io.*;

public class FileHandler {

    public static void main(String[] args) {
        configureHandler();
        
        String content = """
                         Hoje é quarta-feira, dia 22/04/2026. \n
                         Um PÉSSIMO dia para estudar Java! \n
                         Dados armazenados no arquivo.
                         """;
        try { 
            FileHandler.writeToFile("myDataText.txt", content);
        } catch (IOException ex) {
            System.out.println("erro ao armazenar dados");
        }
    }
    
    private static void writeToFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        out.println(content);
        
        out.close();
        bw.close();
        fw.close();
    }
    
    private static void configureHandler() {
        
    }
}
