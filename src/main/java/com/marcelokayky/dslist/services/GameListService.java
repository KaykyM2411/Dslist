package com.marcelokayky.dslist.services;

import com.marcelokayky.dslist.dto.GameListDTO;
import com.marcelokayky.dslist.dto.GameMinDTO;
import com.marcelokayky.dslist.entities.Game;
import com.marcelokayky.dslist.entities.GameList;
import com.marcelokayky.dslist.projection.GameMinProjection;
import com.marcelokayky.dslist.repositories.GameListRepository;
import com.marcelokayky.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
    @Transactional
    public void move (Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
