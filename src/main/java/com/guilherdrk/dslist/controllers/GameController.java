package com.guilherdrk.dslist.controllers;

import com.guilherdrk.dslist.controllers.docs.GameControllerDocs;
import com.guilherdrk.dslist.dto.GameDTO;
import com.guilherdrk.dslist.dto.GameMinDTO;
import com.guilherdrk.dslist.model.Game;
import com.guilherdrk.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController implements GameControllerDocs {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    @Override
    public GameDTO findById(@PathVariable Long id){
        return gameService.findById(id);
    }

    @GetMapping
    @Operation(
            summary = "Finds all Games",
            description = "Finds all Games in the List",
            tags = {"Games"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GameMinDTO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content),
            }

    )
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }
}
