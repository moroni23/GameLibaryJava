package com.minhaaplicacao.game_library.ui.controllers;

import com.minhaaplicacao.game_library.application.services.jogo.AdicionarJogoService;
import com.minhaaplicacao.game_library.application.services.jogo.AtualizarJogoService;
import com.minhaaplicacao.game_library.application.services.jogo.RemoverJogoService;
import com.minhaaplicacao.game_library.domain.entities.UsuarioJogo;
import com.minhaaplicacao.game_library.infrastructure.dto.AdicionarJogoRequestDTO;
import com.minhaaplicacao.game_library.infrastructure.dto.AtualizarJogoRequestDTO;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioJogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
@RequiredArgsConstructor
public class UsuarioJogoController {

    private final AdicionarJogoService adicionarJogoService;

    // 1. Injeção do repositório (Necessário para fazer consultas no banco)
    private final UsuarioJogoRepository usuarioJogoRepository;
    private final AtualizarJogoService atualizarJogoService;
    private final RemoverJogoService removerJogoService;

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioJogo> adicionarJogo(@RequestBody AdicionarJogoRequestDTO request) {

        // Chamamos o serviço passando os dados individuais retirados do DTO
        UsuarioJogo novoVinculo = adicionarJogoService.executar(
                request.getUsuarioId(),
                request.getJogoIdExterno(),
                request.getStatus()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(novoVinculo);
    }

    // 2. Novo método para listar os jogos de um usuário específico
    @GetMapping("/listar/{usuarioId}")
    public ResponseEntity<List<UsuarioJogo>> listarJogos(@PathVariable Long usuarioId) {

        // Busca a lista no banco de dados usando o ID do usuário
        List<UsuarioJogo> jogos = usuarioJogoRepository.findByUsuarioId(usuarioId);

        return ResponseEntity.ok(jogos);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioJogo> atualizarJogo(@RequestBody AtualizarJogoRequestDTO request) {

        UsuarioJogo jogoAtualizado = atualizarJogoService.executar(
                request.getUsuarioId(),
                request.getJogoId(),
                request.getStatus(),
                request.getHorasJogadas()
        );

        return ResponseEntity.ok(jogoAtualizado);
    }

    @DeleteMapping("/remover/{usuarioId}/{jogoId}")
    public ResponseEntity<Void> removerJogo(@PathVariable Long usuarioId, @PathVariable Long jogoId) {

        removerJogoService.executar(usuarioId, jogoId);

        // Retorna 204 No Content (Padrão para deleção com sucesso)
        return ResponseEntity.noContent().build();
    }
}