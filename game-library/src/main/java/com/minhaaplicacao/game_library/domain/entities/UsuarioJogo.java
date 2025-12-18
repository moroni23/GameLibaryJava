package com.minhaaplicacao.game_library.domain.entities;

import com.minhaaplicacao.game_library.domain.enums.StatusJogo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioJogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento Muitos-para-Um: Um utilizador pode ter muitos jogos na lista
    @ManyToOne
    @JoinColumn(name = "usuario_id") // Define o nome da coluna que guardará o ID no banco
    private Usuario usuario;

    // Relacionamento Muitos-para-Um: Um jogo pode estar na lista de muitos utilizadores
    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    private Integer horasJogadas;

    @Enumerated(EnumType.STRING) // Diz ao banco para guardar o texto ("JOGANDO") e não o número (2)
    private StatusJogo status;
}