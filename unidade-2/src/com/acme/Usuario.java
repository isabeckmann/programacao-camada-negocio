package com.acme;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private String nome;
    private String senha;
    private Date dataCriacao;
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.dataCriacao = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    
}
