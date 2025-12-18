package com.minhaaplicacao.game_library.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity // Indica ao Spring (JPA) que esta classe é uma tabela no banco de dados
@Data // O Lombok gera automaticamente Getters, Setters, toString, equals, etc.
@NoArgsConstructor // Gera um construtor vazio (obrigatório para o JPA)
@AllArgsConstructor // Gera um construtor com todos os argumentos


public class Usuario {

    @Id // Marca este campo como a Chave Primária (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // O banco de dados vai gerar o ID automaticamente (auto-increment)
    private Long id;

    private String nome;

    private LocalDate dataNascimento; // Usamos LocalDate pois não precisamos da hora exata, apenas a data
}
