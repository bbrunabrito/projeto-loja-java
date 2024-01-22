package br.com.loja.services;

import br.com.loja.exceptions.CodigoErro;
import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Cliente;
import br.com.loja.models.pessoa.Pessoa;
import br.com.loja.models.pessoa.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static List<Vendedor> listaVendedores = new ArrayList<>();

    public static void registraPessoa(Pessoa pessoa) {
        try {
            if (pessoa instanceof Cliente) {
                salvaCliente((Cliente) pessoa);
                imprimeListaClientes();
            } else {
                salvaVendedor((Vendedor) pessoa);
                imprimeListaVendedores();
            }
        } catch (VendaException e) {
            System.out.println(e);
        }
    }

    public static void imprimeListaVendedores() {

        for (Vendedor vendedor : listaVendedores) {
            System.out.print(vendedor.toString());
            System.out.println("\n-------------------\n");
        }
    }

    public static void imprimeListaClientes() {
        System.out.println("-------------------");
        System.out.println("Lista de Clientes Registrados: ");
        for (Cliente cliente : listaClientes) {
            System.out.print(cliente.toString());
            System.out.println("\n*****************************\n");
        }
        System.out.println("-------------------");
    }

    private static void salvaCliente(Cliente novoCliente) throws VendaException {
        if (listaClientes.contains(novoCliente)) {
            throw new VendaException("Erro no cadastro do Cliente", "O cliente já foi registrado no sistema", CodigoErro.CLIENTE_REGISTRADO_ERRO);
        } else {
            listaClientes.add(novoCliente);
            System.out.println("Cliente registrado com sucesso!");
            System.out.println("\n*****************************\n");
        }
    }

    private static void salvaVendedor(Vendedor novoVendedor) throws VendaException {
        if (listaVendedores.contains(novoVendedor)) {
            throw new VendaException("Erro no cadastro do vendedor", "O vendedor já está registrado no sistema", CodigoErro.VENDEDOR_REGISTRADO_ERRO);
        } else {
            listaVendedores.add(novoVendedor);
            System.out.println("Vendedor registrado com sucesso!");
            System.out.println("\n*****************************\n");
        }
    }


}
