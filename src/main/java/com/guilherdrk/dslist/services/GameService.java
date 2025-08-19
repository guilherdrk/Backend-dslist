package com.guilherdrk.dslist.services;

import com.guilherdrk.dslist.dto.GameDTO;
import com.guilherdrk.dslist.dto.GameMinDTO;
import com.guilherdrk.dslist.model.Game;
import com.guilherdrk.dslist.model.GameList;
import com.guilherdrk.dslist.repository.GameListRepository;
import com.guilherdrk.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> dto = gameRepository.findAll();
        return dto.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found!"));
        GameDTO dto = new GameDTO(result);
        return dto;
    }
}
