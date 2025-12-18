package com.minhaaplicacao.game_library.application.services.jogo;

import com.minhaaplicacao.game_library.domain.entities.UsuarioJogo;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioJogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoverJogoService {

    private final UsuarioJogoRepository usuarioJogoRepository;

    public void executar(Long usuarioId, Long jogoId) {
        // 1. Busca o vínculo para ter certeza que existe
        UsuarioJogo vinculo = usuarioJogoRepository.findByUsuarioIdAndJogoId(usuarioId, jogoId)
                .orElseThrow(() -> new IllegalArgumentException("Jogo não encontrado na lista."));

        // 2. Deleta o registro do banco
        usuarioJogoRepository.delete(vinculo);
    }
}