package com.andriosi.fabio.vendas.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EntityScan("com.andriosi.fabio.vendas.entity")
@ComponentScan({"com.andriosi.fabio.vendas.controllers",
        "com.andriosi.fabio.vendas.services",
        "com.andriosi.fabio.vendas.main"})
public class Main {
    public static void main(String... args){
        SpringApplication.run(Main.class, args);
    }
}
