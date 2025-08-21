package com.guilherdrk.dslist.services;

import com.guilherdrk.dslist.dto.GameListDTO;
import com.guilherdrk.dslist.projections.GameMinProjection;
import com.guilherdrk.dslist.repository.GameListRepository;
import com.guilherdrk.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = false)
    public List<GameListDTO> findAll(){
        var dto = gameListRepository.findAll();
        return dto.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection objRemovido = list.remove(sourceIndex);
        list.add(destinationIndex, objRemovido);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
        // lists/2/games/4/2
    }

}
