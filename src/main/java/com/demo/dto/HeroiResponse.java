package com.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HeroiResponse {

    private Long id;
    private String nomeDoPessoal;
    private String nomeDoHeroi;
    private String superPoder;
    private Integer idade;
    private String emprego;
    private LocalDate dataDeCadastro;
}
