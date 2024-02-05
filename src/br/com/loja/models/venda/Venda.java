package br.com.loja.models.venda;

import br.com.loja.models.produto.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Venda {
    private BigDecimal valorVenda;
    private LocalDateTime dataVenda;
    private BigDecimal quantidade;
    Produto produto;

    public Venda(BigDecimal quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }


    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Venda:\n" +
                "Descrição do Produto: " + this.produto.getDescricao() +
                "\nPreço do Produto: " + this.produto.getPreco() +
                "\nQuantidade: " + this.getQuantidade() +
                "\nValor da Venda: " + this.getValorVenda() +
                "\nData da Venda: " + this.getDataVenda();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda venda)) return false;
        return Objects.equals(produto, venda.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }
}
