package br.com.loja.models.produto;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private String descricao;
    private BigDecimal preco;
    private BigDecimal estoque;
    private String codigo;


    public Produto(){}


    public Produto(String descricao, BigDecimal preco, BigDecimal estoque, String codigo) {
        this.estoque = estoque;
        this.descricao = descricao;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public String getCodigo() { return  codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    @Override
    public String toString() {
        return "Produto:\n" +
                "Descricao='" + descricao + '\'' +
                ",\nPreco=" + preco +
                ",\nEstoque=" + estoque +
                ",\nCodigo='" + codigo + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
