package com.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeDoPessoal;
    private String nomeDoHeroi;
    private String superPoder;
    private Integer idade;
    private String emprego;
    private LocalDate dataDeCadastro;
}
