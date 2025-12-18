package com.minhaaplicacao.game_library.application.services.jogo;

import com.minhaaplicacao.game_library.domain.entities.Jogo;
import com.minhaaplicacao.game_library.domain.entities.Usuario;
import com.minhaaplicacao.game_library.domain.entities.UsuarioJogo;
import com.minhaaplicacao.game_library.domain.enums.StatusJogo;
import com.minhaaplicacao.game_library.infrastructure.dto.GameResponseDTO;
import com.minhaaplicacao.game_library.infrastructure.external.RawgApiClient;
import com.minhaaplicacao.game_library.infrastructure.repository.JogoRepository;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioJogoRepository;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdicionarJogoService {

    private final UsuarioRepository usuarioRepository;
    private final JogoRepository jogoRepository;
    private final UsuarioJogoRepository usuarioJogoRepository;
    private final RawgApiClient rawgApiClient;

    // Injetamos a chave da API que está no application.properties
    @Value("${rawg.api.key}")
    private String apiKey;

    public UsuarioJogo executar(Long usuarioId, Long jogoIdExterno, StatusJogo status) {
        // 1. Buscar o Usuário (se não existir, erro)
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        // 2. Verificar se o Jogo já existe no nosso banco local
        // Nota: Precisamos ter certeza que estamos buscando pelo ID externo, não o ID gerado pelo banco.
        // Para simplificar, vamos assumir que o ID do jogo no nosso banco É o mesmo da RAWG,
        // ou você precisaria de um campo "externalId" na entidade Jogo.
        // Vamos assumir aqui que vamos salvar o ID da RAWG como o ID do nosso banco.

        Optional<Jogo> jogoOptional = jogoRepository.findById(jogoIdExterno);
        Jogo jogo;

        if (jogoOptional.isPresent()) {
            jogo = jogoOptional.get();
        } else {
            // 3. Se não existe localmente, busca na API externa
            try {
                GameResponseDTO gameDto = rawgApiClient.getGameDetails(jogoIdExterno, apiKey);

                // Converte DTO para Entidade
                jogo = new Jogo();
                jogo.setId(gameDto.getId()); // Usamos o mesmo ID da RAWG
                jogo.setNome(gameDto.getName());
                jogo.setUrlImagem(gameDto.getBackgroundImage());

                // Salva o novo jogo no nosso banco para cache
                jogoRepository.save(jogo);

            } catch (Exception e) {
                throw new IllegalArgumentException("Jogo não encontrado na API externa.");
            }
        }

        // 4. Criar o vínculo (UsuarioJogo)
        UsuarioJogo novoVinculo = new UsuarioJogo();
        novoVinculo.setUsuario(usuario);
        novoVinculo.setJogo(jogo);
        novoVinculo.setStatus(status);
        novoVinculo.setHorasJogadas(0); // Começa com 0 horas

        // 5. Salvar e retornar
        return usuarioJogoRepository.save(novoVinculo);
    }
}