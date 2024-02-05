package br.com.loja;

import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Cliente;
import br.com.loja.models.pessoa.Vendedor;
import br.com.loja.models.produto.Produto;
import br.com.loja.services.ProdutoService;
import br.com.loja.services.VendaService;
import br.com.loja.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws VendaException {
        Scanner scanner = new Scanner(System.in);

        // Criando instância da View (Menu)
        Menu menu = new Menu(scanner);

        System.out.println("Bem-vindo à Loja!");
        menu.exibirMenu();


    }
}
