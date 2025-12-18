package com.minhaaplicacao.game_library.infrastructure.repository;

import com.minhaaplicacao.game_library.domain.entities.UsuarioJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioJogoRepository extends JpaRepository<UsuarioJogo, Long> {

    List<UsuarioJogo> findByUsuarioId(Long usuarioId);
    Optional<UsuarioJogo> findByUsuarioIdAndJogoId(Long usuarioId, Long jogoId);
}