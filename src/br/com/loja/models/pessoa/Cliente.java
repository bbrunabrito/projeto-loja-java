package br.com.loja.models.pessoa;

import java.math.BigDecimal;
import java.util.Objects;

public class Cliente extends Pessoa {
    private String cpf;

    public Cliente(){ super();}

    public Cliente(String nome, BigDecimal idade, String genero, String cpf) {
        super(nome, idade, genero);
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Cliente:\nNome: " + this.getNome() +
                "\nIdade: " + this.getIdade() +
                "\nGenero: " + this.getGenero() +
                "\nCPF: " + this.getCpf();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
