package com.andriosi.fabio.vendas.testes;

import com.andriosi.fabio.vendas.entity.Categoria;
import com.andriosi.fabio.vendas.services.CategoriaRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EndToEndTest {
    private Categoria categoria;
    private String url ="/resources/categorias";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CategoriaRepository repository;
    @Test
    public void CategoriaA() throws Exception {
        Categoria c = getCategoria();
        String descricao = c.getDescricao();
        String json = new Utilities().getJson(c);
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .header(HttpHeaders.AUTHORIZATION, "Basic QmVtb2RhYWg6JCNCZW1vZGFhaDQz")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descricao", is(descricao)));
    }
    private Categoria getCategoria(){
        List<Categoria> list = (List<Categoria>) repository.findAll();
        if(list != null){
           return this.categoria = list.get(0);
        }else{
            this.categoria.setDescricao("Teste Categoria");
            return this.categoria;
        }
    }
}
