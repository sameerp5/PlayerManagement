package com.player.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.player.crud.entities.Player;
import com.player.crud.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	public PlayerService playerService;

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("players", playerService.findAll());
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Player player) {
		return "add";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid Player player, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add";
		}

		playerService.savePlayer(player);
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Player player = playerService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Player Id:" + id));
		model.addAttribute("player", player);

		return "update";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Player player, BindingResult result, Model model) {
		if (result.hasErrors()) {
			player.setId(id);
			return "update";
		}

		playerService.savePlayer(player);

		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Player player = playerService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Player Id:" + id));
		playerService.delete(player);

		return "redirect:/index";
	}
}
