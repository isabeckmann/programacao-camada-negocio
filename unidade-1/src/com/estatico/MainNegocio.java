package com.estatico;

public class MainNegocio {

    public static void main(String[] args) {
        System.out.println("--- Iniciando o programa ---");
        ConfiguracaoNegocio c1 = new ConfiguracaoNegocio();
        ConfiguracaoNegocio.exibirConfiguracao();
        
        ConfiguracaoNegocio c2 = new ConfiguracaoNegocio();
        c2.idInstancia = 999;
        ConfiguracaoNegocio.exibirConfiguracao();
        
        ConfiguracaoNegocio c3 = new ConfiguracaoNegocio();
        ConfiguracaoNegocio.exibirConfiguracao();
        
        System.out.println("--- Fim do programa ---");
    }
    
}
