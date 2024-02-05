package br.com.loja.view;


import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Cliente;
import br.com.loja.models.pessoa.Vendedor;
import br.com.loja.models.produto.Produto;
import br.com.loja.services.ClienteService;
import br.com.loja.services.ProdutoService;
import br.com.loja.services.VendaService;
import br.com.loja.services.VendedorService;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private final Scanner input;

    public Menu(Scanner input) {
        this.input = input;
    }

    public void exibirMenu() throws VendaException {
        String opcao;
        do {
            System.out.println("***************************************");
            System.out.println("1. Criar Produto");
            System.out.println("2. Criar Vendedor");
            System.out.println("3. Criar Cliente");
            System.out.println("4. Realizar Venda");
            System.out.println("0. Encerrar Sistema");
            System.out.println("***************************************");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextLine();
            processarOpcao(Integer.parseInt(opcao));

        } while (!Objects.equals(opcao, "0"));
    }

    public void processarOpcao(int opcao) throws VendaException {
        switch (opcao) {
            case 1:
                criaProduto();
                break;
            case 2:
                criaVendedor();
                break;
            case 3:
                criaCliente();
                break;
            case 4:
                realizaVenda();
                break;
            case 0:
                System.out.println("***************************************");
                System.out.println("Sistema encerrado!");
                break;
            default:
                System.out.println("***************************************");
                System.out.println("Opção inválida. Tente novamente.");
        }
        fecharScanner();
    }

    private void criaProduto() {
        System.out.print("Descricao: ");
        String descricao = input.nextLine();
        System.out.print("\nPreco: ");
        BigDecimal preco = input.nextBigDecimal();
        input.nextLine();
        System.out.print("\nEstoque: ");
        BigDecimal estoque = input.nextBigDecimal();
        input.nextLine();
        System.out.print("\nCodigo do produto: ");
        String codigo = input.nextLine();

        Produto novoProduto = new Produto(descricao, preco, estoque, codigo);
        ProdutoService.registraNovoProduto(novoProduto);
    }

    private void criaVendedor() {
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("\nIdade: ");
        BigDecimal idade = input.nextBigDecimal();
        input.nextLine();
        System.out.print("\nGenero: ");
        String genero = input.nextLine();
        System.out.print("\nCodigo do vendedor: ");
        String cod_vendedor = input.nextLine();

        Vendedor novoVendedor = new Vendedor(nome, idade, genero, cod_vendedor);
        VendedorService.registraVendedor(novoVendedor);
    }

    private void criaCliente() throws VendaException {
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("\nIdade: ");
        BigDecimal idade = input.nextBigDecimal();
        input.nextLine();
        System.out.print("\nGenero: ");
        String genero = input.nextLine();
        System.out.print("\nCPF: ");
        String cpf = input.nextLine();

        Cliente novoCliente = new Cliente(nome, idade, genero, cpf);
        ClienteService.registraCliente(novoCliente);
    }

    private void realizaVenda() {
        String codigo;
        BigDecimal quantidade;
        String option;

        try {
            do {
                System.out.print("\nDigite o código do produto que deseja comprar: ");
                codigo = input.nextLine();
                Produto novo = ProdutoService.procuraProdutoPorCodigo(codigo);

                if(novo == null) {
                    throw new NullPointerException("\nFalha: O produto desejado não está registrado no sistema.");
                }
                System.out.print("Digite a quantidade que deseja comprar: ");
                quantidade = input.nextBigDecimal();
                VendaService.adicionarCarrinhoCompras(novo, quantidade);
                System.out.println("Deseja adicionar mais produtos" +
                        "\n1 - Sim" +
                        "\n2 - Não. Concluir a Venda");

                option = input.nextLine();
            } while (!option.equals("2"));
        }
        catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }

        VendaService.processaCarrinhoCompras();
        VendaService.imprimeListaVendas();
    }

    public void fecharScanner() {
        if (input != null) {
            input.close();
        }
    }


}
