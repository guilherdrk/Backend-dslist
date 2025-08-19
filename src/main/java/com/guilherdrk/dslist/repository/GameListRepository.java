package com.guilherdrk.dslist.repository;

import com.guilherdrk.dslist.model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
