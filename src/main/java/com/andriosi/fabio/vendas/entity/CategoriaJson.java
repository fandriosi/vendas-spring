package com.andriosi.fabio.vendas.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaJson {
    private Long id;
    private String descricao;
    @JsonCreator
    public CategoriaJson(@JsonProperty("id") Long id, @JsonProperty("descriacao") String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
