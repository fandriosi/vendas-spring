package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.StringCapitalize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCapitalizeTest {

    @Test
    void getCapitalize() {
        String text = "teste";
        assertEquals("Teste", new StringCapitalize().getCapitalize(text));
    }
}