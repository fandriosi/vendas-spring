package com.andriosi.fabio.vendas.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 2365932197989L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nome;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = new StringCapitalize().getCapitalize(nome);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
