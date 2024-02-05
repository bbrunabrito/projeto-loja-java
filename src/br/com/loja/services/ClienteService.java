package br.com.loja.services;

import br.com.loja.exceptions.CodigoErro;
import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static List<Cliente> listaClientes = new ArrayList<>();

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void registraCliente(Cliente novoCliente) throws VendaException {
         try {
             checaSeClienteExiste(novoCliente);
             listaClientes.add(novoCliente);
             System.out.println("Cliente registrado com sucesso!");
             imprimeListaClientes();
        }
         catch (VendaException e) {
             System.out.println(e);
         }
    }
    public static void imprimeListaClientes() {
        if(listaClientes.isEmpty()) {
            throw new RuntimeException("Não existe clientes cadastrados no sistema");
        }

        System.out.println("-------------------");
        System.out.println("Lista de Clientes Registrados: ");
        for (Cliente cliente : listaClientes) {
            System.out.print(cliente.toString());
            System.out.println("\n*****************************\n");
        }
        System.out.println("-------------------");
    }

    private static void checaSeClienteExiste(Cliente novoCliente) throws VendaException {
        if (listaClientes.contains(novoCliente)) {
            throw new VendaException("Erro no cadastro do Cliente", "O cliente já foi registrado no sistema", CodigoErro.CLIENTE_REGISTRADO_ERRO);
        }
    }

}
