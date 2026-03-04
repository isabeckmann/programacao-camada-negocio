package exercicios;

import java.util.ArrayList;
import java.util.List;

public class TestContrato {
    public static void main(String[] args) {
        List<Contrato> lista1 = gerarContratos(5);
        List<Contrato> lista2 = gerarContratos(15);
        lista1.addAll(lista2);
        
        print( lista1 );
    }
    
    private static void print(List<Contrato> contratos) {
        for(Contrato c : contratos) {
            System.out.println(c.getClausulas().toString());
        }
    }
    
    private static List<Contrato> gerarContratos(int qtd) {
        List<Contrato> res = new ArrayList();
        for (int i=0; i<qtd; i++) {
            Contrato c = new Contrato();
            c.addClausulas("cláusula 1", "cláusula 2", "cláusula 3");
            c.addClausulas("cláusula 4");

            Pessoa p = new Pessoa();
            p.setNome("João");
            p.setTelefone("991813392");

            c.setContratante(p);
            c.setValor(10_000);
        }
        return res;
    }
    
}
