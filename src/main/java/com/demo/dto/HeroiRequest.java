package com.demo.dto;

import lombok.Data;

@Data
public class HeroiRequest {

    private String nomeDoPessoal;
    private String nomeDoHeroi;
    private String superPoder;
    private Integer idade;
    private String emprego;
}
