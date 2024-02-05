package br.com.loja.test;

import br.com.loja.models.pessoa.Vendedor;
import br.com.loja.services.VendedorService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class VendedorServiceTest {
    private final Vendedor vendedor1 = new Vendedor("José", new BigDecimal(18), "Masculino", "123");
    private final Vendedor vendedor2 = new Vendedor("José", new BigDecimal(18), "Masculino", "123");


    @Test
    void registraVendedor() {
        VendedorService.registraVendedor(vendedor1);
        assertTrue(VendedorService.getListaVendedores().contains(vendedor1));
    }

    @Test
    void registraVendedorExistente() {
        VendedorService.registraVendedor(vendedor2);
        assertFalse(VendedorService.getListaVendedores().contains(vendedor2.getCodVendedor()) &&
                VendedorService.getListaVendedores().contains(vendedor2.getNome()));
    }

    @Test
    void imprimeListaVendedores() {
        assertDoesNotThrow(() -> VendedorService.imprimeListaVendedores());
    }

    @Test
    void imprimeListaVendedoresVazia() {
        VendedorService.getListaVendedores().clear();
        assertThrows(RuntimeException.class, () -> VendedorService.imprimeListaVendedores());
    }
}