package br.com.loja.test;

import br.com.loja.models.produto.Produto;
import br.com.loja.services.ProdutoService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {
    private final Produto test1 = new Produto("Teste 1", BigDecimal.valueOf(100), BigDecimal.valueOf(100), "100");
    private final Produto test2 = new Produto("Teste 2", BigDecimal.valueOf(200), BigDecimal.valueOf(200), "100");
    private final Produto test3 = new Produto("Teste 3", BigDecimal.valueOf(300), BigDecimal.valueOf(300), "300");


    @Test
    void registraNovoProduto() {
        ProdutoService.registraNovoProduto(test1);
        assertTrue(ProdutoService.getListaProdutos().contains(test1));
    }

    @Test
    void registraProdutoExistente() {
        ProdutoService.registraNovoProduto(test2);
        assertEquals(false, ProdutoService.getListaProdutos().contains(test2.getDescricao()) &&
                ProdutoService.getListaProdutos().contains(test2.getCodigo()));
    }

    @Test
    void procuraProdutoPorCodigo() {
        assertNotNull(ProdutoService.procuraProdutoPorCodigo(test1.getCodigo()));
    }

    @Test
    void procuraProdutoPorCodigoNaoExistente() {
        assertNull(ProdutoService.procuraProdutoPorCodigo(test3.getCodigo()));
    }

}