package br.com.loja.test;

import br.com.loja.exceptions.VendaException;
import br.com.loja.models.pessoa.Cliente;
import br.com.loja.services.ClienteService;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {
    private List<Cliente> listaClientesTest = new ArrayList<>();

    private Cliente mockCliente() {
        return new Cliente();
    }


    @Test
    void registraCliente() throws VendaException {
        Cliente c1 = new Cliente("Nome", BigDecimal.valueOf(25), "Masculino", "123456789");
        ClienteService.registraCliente(c1);
        assertTrue(ClienteService.getListaClientes().contains(c1));
    }

    @Test
    void registraClienteExistente() throws VendaException {
        Cliente c2 = new Cliente("Bruna", BigDecimal.valueOf(25), "Feminino", "123456789");
        ClienteService.registraCliente(c2);
        assertEquals(false, ClienteService.getListaClientes().contains(c2.getNome()) &&
                ClienteService.getListaClientes().contains(c2.getCpf()));
    }

    @Test
    void imprimeListaClientes() {
        assertDoesNotThrow(() -> ClienteService.imprimeListaClientes());
    }

    @Test
    void imprimeListaClientesVazia(){
        ClienteService.getListaClientes().clear();
        assertThrows(RuntimeException.class, () -> ClienteService.imprimeListaClientes());
    }
}