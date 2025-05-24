package com.marcelokayky.dslist.services;

import com.marcelokayky.dslist.dto.GameMinDTO;
import com.marcelokayky.dslist.entities.Game;
import com.marcelokayky.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
