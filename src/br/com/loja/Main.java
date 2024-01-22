package br.com.loja;

import br.com.loja.controller.MenuController;
import br.com.loja.models.pessoa.Cliente;
import br.com.loja.models.pessoa.Vendedor;
import br.com.loja.models.produto.Produto;
import br.com.loja.services.ProdutoService;
import br.com.loja.services.VendaService;
import br.com.loja.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instância da View (Menu) e do Controller (MenuController)
        Menu menu = new Menu(scanner);
        MenuController controller = new MenuController(menu);

        System.out.println("Bem-vindo à Loja!");
        //menu.exibirMenu();

        Produto p1 = new Produto("Mesa", BigDecimal.valueOf(456.93), BigDecimal.TEN, "4A526");
        Produto p2 = new Produto("Liquidificador", BigDecimal.valueOf(96), BigDecimal.TEN, "78C12");

        Cliente c1 = new Cliente("Bruna", BigDecimal.valueOf(23), "Feminino", "78945612300");

        Vendedor v1= new Vendedor("Peter", BigDecimal.valueOf(45), "Masculino", "7896");



//        ProdutoService.criaProduto(p1);
//        ProdutoService.criaProduto(p1);

//        PessoaService.registraPessoa(v1);
//        PessoaService.registraPessoa(v1);

//        PessoaService.registraPessoa(c1);
//        PessoaService.registraPessoa(c1);
//        PessoaService.registraPessoa(v1);
//        PessoaService.registraPessoa(v1);

        ProdutoService.registraNovoProduto(p1);
        ProdutoService.registraNovoProduto(p2);
        VendaService.adicionarCarrinhoCompras(p1, BigDecimal.TWO);
        VendaService.adicionarCarrinhoCompras(p2, BigDecimal.valueOf(11));
        VendaService.processaCompra();


        /*ProdutoService.criaProduto(p1);
        ProdutoService.criaProduto(p2);
        PessoaService.registraPessoa(c1);
        PessoaService.registraPessoa(v1);
        VendaService.adicionarCarrinhoCompras(p1, BigDecimal.TWO);
        VendaService.adicionarCarrinhoCompras(p2, BigDecimal.TEN);
        VendaService.concluirComprar();
        VendaService.imprimeListaVendas();*/
    }
}
