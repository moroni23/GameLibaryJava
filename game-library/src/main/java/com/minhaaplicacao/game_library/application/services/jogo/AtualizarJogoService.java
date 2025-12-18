package com.minhaaplicacao.game_library.application.services.jogo;

import com.minhaaplicacao.game_library.domain.entities.UsuarioJogo;
import com.minhaaplicacao.game_library.domain.enums.StatusJogo;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioJogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarJogoService {

    private final UsuarioJogoRepository usuarioJogoRepository;

    public UsuarioJogo executar(Long usuarioId, Long jogoId, StatusJogo novoStatus, Integer novasHoras) {
        // 1. Busca o vínculo específico (Usuario + Jogo)
        UsuarioJogo vinculo = usuarioJogoRepository.findByUsuarioIdAndJogoId(usuarioId, jogoId)
                .orElseThrow(() -> new IllegalArgumentException("Jogo não encontrado na lista deste usuário."));

        // 2. Atualiza os dados se eles foram passados (diferente de null)
        if (novoStatus != null) {
            vinculo.setStatus(novoStatus);
        }

        if (novasHoras != null) {
            vinculo.setHorasJogadas(novasHoras);
        }

        // 3. Salva e retorna atualizado
        return usuarioJogoRepository.save(vinculo);
    }
}