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

    public static void registraPessoa(Pessoa pessoa) {
        if (pessoa instanceof Cliente) {
            try {
                salvaCliente((Cliente) pessoa);
            }
            catch (VendaException e) {
                System.out.println(e);
            }
            finally {
                imprimeListaClientes();
            }
        } else {
            try {
                salvaVendedor((Vendedor) pessoa);
            }
            catch (VendaException e) {
                System.out.println(e);
            }
            finally {
                imprimeListaVendedores();
            }
        }
    }

    public static void imprimeListaVendedores() {
        System.out.println("-------------------");
        System.out.println("Lista de Vendedores Registrados: ");
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
}
