package br.com.loja.services;

import br.com.loja.exceptions.CodigoErro;
import br.com.loja.exceptions.VendaException;
import br.com.loja.models.produto.Produto;
import br.com.loja.models.venda.Venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendaService {
    private static List<Venda> listaVendas = new ArrayList<>();
    private static List<Venda> carrinho = new ArrayList<>();


    public static void processaCompra() {
        BigDecimal valorTotalVenda = BigDecimal.ZERO;
        for (Venda item : carrinho) {
            try {
                processaVenda(item);
                atualizaEstoque(item);
                valorTotalVenda = calculaValorTotalVenda(valorTotalVenda, item);

                System.out.println("\n" +  "Venda realizada com sucesso!" +
                        "\nValor da venda: " + item.getValorVenda() +
                        "\nProduto: " + item.getProduto().getDescricao());
            }
            catch (VendaException e) {
                System.out.println(e.toString());
                listaVendas.clear();
                break;
            }
        }
        carrinho.clear();
    }

    public static void imprimeListaVendas() {
        if(listaVendas == null) {
            System.out.println("-------------------");
            System.out.println("Produtos Comprados: ");
            for (Venda venda : listaVendas) {
                System.out.println(venda);
                System.out.println("-------------------");
            }
            System.out.println("-------------------");
        }
        System.out.println("Não foi possível concluir a venda");
    }
    private static void processaVenda(Venda item) throws VendaException {
        if (!checaEstoqueParaProcessarCompra(item.getProduto(), item.getQuantidade())) {
            throw new VendaException("Erro no processamento da venda", "Não tem estoque suficiente", CodigoErro.PROCESSA_VENDA_ERRO);
        }
        item.setValorVenda(item.getProduto().getPreco().multiply(item.getQuantidade()));
        item.setDataVenda(LocalDateTime.now());
        listaVendas.add(item);
    }

    private static void atualizaEstoque(Venda item) {
        item.getProduto().setEstoque(item.getProduto().getEstoque().subtract(item.getQuantidade()));
    }

    public static void adicionarCarrinhoCompras(Produto produto, BigDecimal quantidade) {
        Venda novoVenda = new Venda(quantidade, produto);
        carrinho.add(novoVenda);
    }


    private static BigDecimal calculaValorTotalVenda(BigDecimal valorAtual, Venda item) {
        return valorAtual.add(item.getValorVenda());
    }

    private static boolean checaEstoqueParaProcessarCompra(Produto produto, BigDecimal quantidade) {
        return produto.getEstoque() != null && produto.getEstoque().compareTo(quantidade) >= 0 && produto.getPreco() != null;
    }

}
