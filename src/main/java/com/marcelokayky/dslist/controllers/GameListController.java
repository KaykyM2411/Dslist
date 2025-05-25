package com.marcelokayky.dslist.controllers;

import com.marcelokayky.dslist.dto.GameDTO;
import com.marcelokayky.dslist.dto.GameListDTO;
import com.marcelokayky.dslist.dto.GameMinDTO;
import com.marcelokayky.dslist.dto.ReplacementDTO;
import com.marcelokayky.dslist.services.GameListService;
import com.marcelokayky.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){

        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {

        return gameService.findByList(listId);
    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO dto) {
        gameListService.move(listId, dto.getSoureIndex(), dto.getDestinationIndex());
    }
}
