package br.com.loja.models.pessoa;

import java.math.BigDecimal;

public class Pessoa {
    private String nome;
    private BigDecimal idade;
    private String genero;

    public Pessoa(String nome, BigDecimal idade, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getIdade() {
        return idade;
    }

    public void setIdade(BigDecimal idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}

