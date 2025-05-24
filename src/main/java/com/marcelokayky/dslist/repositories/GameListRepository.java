package com.marcelokayky.dslist.repositories;

import com.marcelokayky.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
