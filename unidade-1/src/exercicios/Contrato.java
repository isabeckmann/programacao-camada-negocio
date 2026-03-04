package exercicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class Contrato {
    private Date data;
    private Pessoa contratante;
    private float valor;
    private List<String> clausulas;

    public Contrato() {
        this.data = new Date();
        this.clausulas = new ArrayList();
    }

    public Pessoa getContratante() {
        return contratante;
    }

    public void setContratante(Pessoa contratante) {
        this.contratante = contratante;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addClausulas(String... clausulas) {
        ArrayList<String> t = new ArrayList();
        for(String s : clausulas) {
            t.add(s);
        }
        this.clausulas.addAll(t);
    }
    
    public StringBuilder getClausulas() {
        StringBuilder res = new StringBuilder();
        for (String s : this.clausulas) {
            res.append(s);
        }
        return res;
    }
}
