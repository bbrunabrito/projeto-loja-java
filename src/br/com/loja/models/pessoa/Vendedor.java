package br.com.loja.models.pessoa;

import java.math.BigDecimal;
import java.util.Objects;

public class Vendedor extends Pessoa {
    private String codVendedor;

    public Vendedor(String nome, BigDecimal idade, String genero, String codVendedor) {
        super(nome, idade, genero);
        this.codVendedor = codVendedor;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String toString() {
        return "Vendedor:\nNome: " + this.getNome() +
                "\nIdade: " + this.getIdade() +
                "\nGenero: " + this.getGenero() +
                "\nCódigo: " + this.getCodVendedor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(codVendedor, vendedor.codVendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codVendedor);
    }
}
