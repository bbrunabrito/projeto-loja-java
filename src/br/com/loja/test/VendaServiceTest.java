package br.com.loja.test;

import br.com.loja.models.produto.Produto;
import br.com.loja.models.venda.Venda;
import br.com.loja.services.VendaService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendaServiceTest {

    private final Venda item = new Venda(BigDecimal.TEN, mockProduto());
    private final Venda item2 = new Venda(BigDecimal.TEN, mockProduto());
    private final Venda item3 = new Venda(BigDecimal.TEN, mockProduto());
    private final Venda item4 = new Venda(BigDecimal.TEN, mockProduto());
    private List<Venda> carrinhoTest = VendaService.getCarrinho();

    Produto mockProduto() {
        return new Produto();
    }

    void setup(){
        item.getProduto().setEstoque(BigDecimal.valueOf(16));
        item.getProduto().setPreco(BigDecimal.valueOf(100));
        carrinhoTest = VendaService.getCarrinho();
    }

    @Test
    void adicionarCarrinhoCompras() {
        setup();
        VendaService.adicionarCarrinhoCompras(item.getProduto(), BigDecimal.TEN);
        assertTrue(VendaService.getCarrinho().contains(item));
    }

    @Test
    void adicionarCarrinhoComprasProdutoNull(){
        Produto produto = null;
        assertThrows(NullPointerException.class, () -> VendaService.adicionarCarrinhoCompras(produto, BigDecimal.TEN));
    }

    @Test
    void adicionarCarrinhoComprasQuantidadeNull(){
        assertThrows(NullPointerException.class, () -> VendaService.adicionarCarrinhoCompras(item.getProduto(), null));
    }

    @Test
    void processaCarrinhoCompra() {
        setup();
        VendaService.adicionarCarrinhoCompras(item.getProduto(), BigDecimal.TEN);
        VendaService.processaCarrinhoCompras();
        assertTrue(VendaService.getListaVendas().contains(item));
    }

    @Test
    void processaCarrinhoCompraComProdutoEstoqueNullProdutoPrecoNull() {
        VendaService.getCarrinho().add(item2);
        VendaService.processaCarrinhoCompras();
        assertFalse(VendaService.getListaVendas().contains(item2));
    }


    @Test
    void processaCarrinhoCompraComProdutoEstoqueValidoProdutoPrecoNull() {
        item3.getProduto().setEstoque(BigDecimal.valueOf(16));
        VendaService.getCarrinho().add(item3);
        VendaService.processaCarrinhoCompras();
        assertFalse(VendaService.getListaVendas().contains(item3));
    }

    @Test
    void processaCarrinhoCompraComProdutoSemEstoqueSuficiente() {
        item4.getProduto().setEstoque(BigDecimal.valueOf(9));
        item4.getProduto().setPreco(BigDecimal.valueOf(10));
        VendaService.getCarrinho().add(item4);
        VendaService.processaCarrinhoCompras();
        assertFalse(VendaService.getListaVendas().contains(item4));
    }


    @Test
    void imprimeListaVendas() {
        setup();
        VendaService.adicionarCarrinhoCompras(item.getProduto(), BigDecimal.TEN);
        VendaService.processaCarrinhoCompras();
        assertDoesNotThrow(() -> VendaService.imprimeListaVendas());;
    }

    @Test
    void imprimeListaVendasVazia(){
        VendaService.getListaVendas().clear();
        assertThrows(NullPointerException.class, () -> VendaService.imprimeListaVendas());
    }



}