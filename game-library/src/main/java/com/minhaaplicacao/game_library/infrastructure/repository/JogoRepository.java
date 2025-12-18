package com.minhaaplicacao.game_library.infrastructure.repository;

import com.minhaaplicacao.game_library.domain.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    // Atenção aqui: o nome deve ser JogoRepository, e não JpaRepository
}