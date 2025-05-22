package com.marcelokayky.dslist.repositories;

import com.marcelokayky.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository  extends JpaRepository<Game, Long> {

}
