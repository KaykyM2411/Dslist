package com.marcelokayky.dslist.services;

import com.marcelokayky.dslist.dto.GameDTO;
import com.marcelokayky.dslist.dto.GameMinDTO;
import com.marcelokayky.dslist.entities.Game;
import com.marcelokayky.dslist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
