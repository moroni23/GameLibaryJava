package com.minhaaplicacao.game_library.infrastructure.repository;

import com.minhaaplicacao.game_library.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}