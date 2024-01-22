package br.com.loja.services;

import br.com.loja.exceptions.CodigoErro;
import br.com.loja.exceptions.VendaException;
import br.com.loja.models.produto.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProdutoService {
    private static List<Produto> listaProdutos = new ArrayList<>();

    public static void registraNovoProduto(Produto novoProduto) {
        try {
            checaSeProdutoResgitrado(novoProduto);
        }
        catch (VendaException e) {
            System.out.println("Erro no cadastro:\n" + e);
        }
    }

    public static Produto procuraProdutoPorCodigo(String codigo) {
        for (Produto produto : listaProdutos) {
            if (Objects.equals(produto.getCodigo(), codigo)) {
                return produto;
            }
        }
        return null;
    }

    private static void checaSeProdutoResgitrado(Produto novoProduto) throws VendaException {
        if(listaProdutos.contains(novoProduto)) {
            throw new VendaException("Erro no registro do produto", "Produto já registrado no sistema!", CodigoErro.PRODUTO_NAO_REGISTRADO);
        }
        else {
            listaProdutos.add(novoProduto);
            System.out.println("Produto registrado com sucesso!");
            System.out.println("*****************************");
            imprimeListaProdutos();
        }
    }

    private static void imprimeListaProdutos() {
        System.out.println("Lista de Produtos Registrados:");
        for (Produto produto : listaProdutos) {
            System.out.println(produto);
            System.out.println("*****************************");
        }
    }


}
