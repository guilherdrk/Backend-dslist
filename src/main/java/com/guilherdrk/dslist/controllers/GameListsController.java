package com.guilherdrk.dslist.controllers;

import com.guilherdrk.dslist.controllers.docs.GameListsControllerDocs;
import com.guilherdrk.dslist.dto.GameDTO;
import com.guilherdrk.dslist.dto.GameListDTO;
import com.guilherdrk.dslist.dto.GameMinDTO;
import com.guilherdrk.dslist.dto.ReplacementeDTO;
import com.guilherdrk.dslist.services.GameListService;
import com.guilherdrk.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListsController implements GameListsControllerDocs {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    @Override
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    @Override
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);

        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    @Override
    public void moveListReplacement(@PathVariable Long listId, @RequestBody ReplacementeDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

//    SELECT TB_BELONGING .*, TB_GAME.TITLE FROM TB_BELONGING
//    INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING.GAME_ID
//    WHERE LIST_ID = 2
//    ORDER BY POSITION
}
