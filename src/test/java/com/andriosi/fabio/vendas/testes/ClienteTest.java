package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.Cliente;
import com.andriosi.fabio.vendas.entity.StringCapitalize;
import com.andriosi.fabio.vendas.services.ClienteFacade;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityExistsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
    //@Test
    public void clienteTesteA() throws EntityExistsException {
        Cliente cliente = new Cliente();
        cliente.setNome("Thais ");
        new ClienteFacade().create(cliente);
    }
  // @Test
    public void clienteTesteB() {
        Cliente cliente = new ClienteFacade().findAll().get(0);
        assertEquals("Gisele", cliente.getNome());
   }
   //@Test
    public void clienteTesteC(){
        Cliente cliente = new ClienteFacade().findAll().get(0);
        cliente.setNome("Jose Da Silava");
        assertEquals("Jose Da Silava", cliente.getNome());
    }
    //@Test
    public void clienteTesteD(){
        ClienteFacade clienteFacade = new ClienteFacade();
        Cliente cliente = clienteFacade.findAll().get(0);
        long id = cliente.getId();
        clienteFacade.remove(cliente);
        Cliente clientet = clienteFacade.find(id);
        assertNull("The car should be null", clientet);
    }
   // @Test
    public void capitalizeStrTest(){
        StringCapitalize capitalize = new StringCapitalize();
        assertEquals("Fabio Luis Andriosi", capitalize.getCapitalize("fabio luis andriosi"));
    }

}
