package com.guilherdrk.dslist.services;

import com.guilherdrk.dslist.dto.GameListDTO;
import com.guilherdrk.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> findAll(){
        var dto = gameListRepository.findAll();
        return dto.stream().map(x -> new GameListDTO(x)).toList();
    }

}
