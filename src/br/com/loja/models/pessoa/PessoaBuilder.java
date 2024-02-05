package br.com.loja.models.pessoa;

import java.math.BigDecimal;

public class PessoaBuilder {
    private String nome;
    private BigDecimal idade;
    private String genero;

    public PessoaBuilder() {}

    public static PessoaBuilder pBuilder() {
        return new PessoaBuilder();
    }

    public PessoaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder idade(BigDecimal idade){
        this.idade = idade;
        return this;
    }

    public PessoaBuilder genero(String genero) {
        this.genero = genero;
        return this;
    }

    public Pessoa build() {
        return new Pessoa(
                nome,
                idade,
                genero
        );
    }
}
