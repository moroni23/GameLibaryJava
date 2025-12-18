package com.minhaaplicacao.game_library.infrastructure.dto;

import com.minhaaplicacao.game_library.domain.enums.StatusJogo;
import lombok.Data;

@Data
public class AdicionarJogoRequestDTO {
    private Long usuarioId;
    private Long jogoIdExterno;
    private StatusJogo status;
}