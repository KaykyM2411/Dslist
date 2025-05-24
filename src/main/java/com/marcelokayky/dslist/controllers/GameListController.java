package com.marcelokayky.dslist.controllers;

import com.marcelokayky.dslist.dto.GameListDTO;
import com.marcelokayky.dslist.dto.GameMinDTO;
import com.marcelokayky.dslist.services.GameListService;
import com.marcelokayky.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){

        return gameListService.findAll();
    }
}
