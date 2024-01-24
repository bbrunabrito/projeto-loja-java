package br.com.loja.services;

import br.com.loja.exceptions.CodigoErro;
import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorService {
    private static List<Vendedor> listaVendedores = new ArrayList<>();

    public static void registraVendedor(Vendedor novoVendedor) {
        try {
            checaSeVendedorExiste(novoVendedor);
            listaVendedores.add(novoVendedor);
            System.out.println("Vendedor registrado com sucesso!");
            imprimeListaVendedores();
        }
        catch (VendaException e) {
            System.out.println(e);
        }
    }
    public static void imprimeListaVendedores() {
        for (Vendedor vendedor : listaVendedores) {
            System.out.print(vendedor.toString());
            System.out.println("\n-------------------\n");
        }
    }

    private static void checaSeVendedorExiste(Vendedor novoVendedor) throws VendaException {
        if (listaVendedores.contains(novoVendedor)) {
            throw new VendaException("Erro no cadastro do vendedor", "O vendedor já está registrado no sistema", CodigoErro.VENDEDOR_REGISTRADO_ERRO);
        }
    }

}
