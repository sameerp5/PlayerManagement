package com.player.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.crud.entities.Player;
import com.player.crud.repo.UserRepository;

@Service
public class PlayerService {

	@Autowired
	private UserRepository userRepository;

	public void savePlayer(Player player) {
		userRepository.save(player);
	}

	public Iterable<Player> findAll() {
		return userRepository.findAll();
	}

	public Optional<Player> findById(long id) {
		return userRepository.findById(id);
	}

	public void delete(Player player) {
		userRepository.delete(player);

	}

}
