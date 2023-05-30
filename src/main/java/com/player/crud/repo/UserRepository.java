package com.player.crud.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.player.crud.entities.Player;

@Repository
public interface UserRepository extends CrudRepository<Player, Long> {
    
    List<Player> findByName(String name);
    
}
