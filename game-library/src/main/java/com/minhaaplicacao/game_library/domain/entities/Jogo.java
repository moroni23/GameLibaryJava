package com.minhaaplicacao.game_library.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jogo {

    @Id

    private Long id; // Nosso ID interno (Primary Key do H2)

    @Column(unique = true, nullable = false)


    private String nome;

    private String urlImagem;
}