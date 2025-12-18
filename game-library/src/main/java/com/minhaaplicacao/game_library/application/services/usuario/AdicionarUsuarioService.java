package com.minhaaplicacao.game_library.application.services.usuario;

import com.minhaaplicacao.game_library.domain.entities.Usuario;
import com.minhaaplicacao.game_library.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 1. Diz ao Spring: "Gerencie esta classe, ela contém regras de negócio"
@RequiredArgsConstructor // 2. O Lombok cria um construtor com todos os campos 'final'
public class AdicionarUsuarioService {

    // 3. Declaramos o repositório como 'final'.
    // Como é 'final', ele PRECISA ser inicializado no construtor (que o Lombok criou para nós).
    private final UsuarioRepository usuarioRepository;

    // Método para executar a ação
    public Usuario executar(Usuario usuario) {
        // Validação
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            // Lança o erro e para a execução aqui
            throw new IllegalArgumentException("O nome do usuário é obrigatório");
        }

        // Se passou pela validação, salva no banco
        return usuarioRepository.save(usuario);
    }
}