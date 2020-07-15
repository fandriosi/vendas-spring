package com.andriosi.fabio.vendas.entity;

public class StringCapitalize {
    public String getCapitalize(String string){
        String str ="";
        String [] arrayStr = string.split(" ");
        for(String aStr : arrayStr){
            str += aStr.substring(0,1).toUpperCase().concat(aStr.substring(1).toLowerCase()).concat(" ");
        }
        return str.trim();
    }
}
