package br.com.loja.view;


import br.com.loja.controller.MenuController;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private final MenuController controller;
    private final Scanner input;

    public Menu(Scanner input) {
        this.controller = new MenuController(this);
        this.input = input;
    }

    public void exibirMenu() {
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
            controller.processarOpcao(Integer.valueOf(opcao));

        } while (!Objects.equals(opcao, "0"));
    }




}
