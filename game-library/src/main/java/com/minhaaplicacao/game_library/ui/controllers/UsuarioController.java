package com.minhaaplicacao.game_library.ui.controllers;

import com.minhaaplicacao.game_library.application.services.usuario.AdicionarUsuarioService;
import com.minhaaplicacao.game_library.domain.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios") // Define o prefixo da URL para todos os endpoints desta classe
@RequiredArgsConstructor // Injeção de dependência automática do Lombok
public class UsuarioController {

    private final AdicionarUsuarioService adicionarUsuarioService;

    @PostMapping("/adicionar") // Define que este método responde a requisições POST
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        // @RequestBody diz ao Spring: "Pegue o JSON que veio na requisição e transforme num objeto Usuario"

        Usuario novoUsuario = adicionarUsuarioService.executar(usuario);

        // Retorna o status 201 (Created) e o usuário criado
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}