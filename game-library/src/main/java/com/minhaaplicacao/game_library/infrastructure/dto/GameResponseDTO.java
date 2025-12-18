package com.minhaaplicacao.game_library.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data // Gera Getters e Setters automaticamente
public class GameResponseDTO {

    private Long id;

    private String name;

    // Mapeia o campo "background_image" do JSON para "backgroundImage" do Java
    @JsonProperty("background_image")
    private String backgroundImage;
}