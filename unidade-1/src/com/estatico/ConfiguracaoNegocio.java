package com.estatico;
import java.util.Random;

public class ConfiguracaoNegocio {
    public static int idInstancia;
    
    static {
        System.out.println("Iniciando recursos da camada de negocio...");
        Random gerarId = new Random();
        
        idInstancia = gerarId.nextInt(1000);
    }
    
    public static void exibirConfiguracao() {
        System.out.println("ID de config: " + idInstancia);
    }
}
