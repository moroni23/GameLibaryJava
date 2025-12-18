package com.minhaaplicacao.game_library.infrastructure.dto;

import com.minhaaplicacao.game_library.domain.enums.StatusJogo;
import lombok.Data;

@Data
public class AtualizarJogoRequestDTO {
    private Long usuarioId;
    private Long jogoId; // Atenção: aqui usamos o ID do jogo no nosso banco
    private StatusJogo status;
    private Integer horasJogadas;
}