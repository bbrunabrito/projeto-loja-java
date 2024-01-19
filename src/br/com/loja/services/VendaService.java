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

    public static void registraVenda(Venda item) {
        if (possivelComprar(item.getProduto(), item.getQuantidade())) {
            item.setValorVenda(item.getProduto().getPreco().multiply(item.getQuantidade()));
            item.setDataVenda(LocalDateTime.now());
            listaVendas.add(item);
            ProdutoService.subtraiEstoque(item.getProduto(), item.getQuantidade());

            System.out.println("\n" +  "Venda realizada com sucesso!" +
                    "\nValor da venda: " + item.getValorVenda() +
                    "\nProduto: " + item.getProduto().getDescricao());
        }
    }

    public static void adicionarCarrinhoCompras(Produto produto, BigDecimal quantidade) {
        Venda novoVenda = new Venda(quantidade, produto);
        carrinho.add(novoVenda);
    }


    private static void possivelConcluirCompra(Venda item, BigDecimal valorTotalVenda) throws VendaException {
        if(!listaVendas.contains(item)) {
            throw new VendaException("Erro na compra do produto",
                    "O produto não tem estoque para a quantidade que deseja comprar",
                    CodigoErro.COMPRA_NAO_CONCLUIDA);
        }
        else {
            valorTotalVenda = valorTotalVenda.add(item.getValorVenda());
        }
    }

    public static void concluirComprar() {
        BigDecimal valorTotalVenda = BigDecimal.ZERO;
        for (Venda item : carrinho) {
            try {
                registraVenda(item);
                possivelConcluirCompra(item, valorTotalVenda);

            }
            catch (VendaException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("Valor total: " + valorTotalVenda);
        carrinho.clear();
    }

    private static boolean possivelComprar(Produto produto, BigDecimal quantidade) {
        return produto.getEstoque() != null && produto.getEstoque().compareTo(quantidade) >= 0 && produto.getPreco() != null;
    }

    public static void imprimeListaVendas() {
        System.out.println("-------------------");
        System.out.println("Produtos Comprados: ");
        for (Venda venda : listaVendas) {
            System.out.println(venda);
            System.out.println("-------------------");
        }
        System.out.println("-------------------");
    }
}
