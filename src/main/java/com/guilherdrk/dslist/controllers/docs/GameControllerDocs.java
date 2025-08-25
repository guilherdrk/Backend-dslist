package com.guilherdrk.dslist.controllers.docs;

import com.guilherdrk.dslist.dto.GameDTO;
import com.guilherdrk.dslist.dto.GameMinDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GameControllerDocs {
    @Operation(
            summary = "Find Game by Id",
            description = "Finding a Game in the List by Id",
            tags = {"Games"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GameDTO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content),
            }

    )
    GameDTO findById(@PathVariable Long id);

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
    public List<GameMinDTO> findAll();

}
