package com.guilherdrk.dslist.repository;

import com.guilherdrk.dslist.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
