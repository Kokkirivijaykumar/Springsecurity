package com.te.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootdemo.dto.Player;
import com.te.springbootdemo.dto.PlayerResponse;
import com.te.springbootdemo.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService service;

	@PostMapping("/insert")
	@ResponseBody
	public PlayerResponse addPlayer(@RequestBody Player player) {

		PlayerResponse response = new PlayerResponse();

		Player myPlayer = service.insertPlayer(player);
		if (myPlayer != null) {
			response.setStatusCode(200);
			response.setMsg("successful");
			response.setDesc("player inserted successfully");
			response.setPlayer(myPlayer);
		} else {
			response.setStatusCode(400);
			response.setMsg("Failed");
			response.setDesc("Unable to insert player");
		}
		return response;
	}

	@PutMapping("/update")
	@ResponseBody
	public PlayerResponse updatePlayer(@RequestBody Player player) {
		PlayerResponse response = new PlayerResponse();
		Player myUpdatedPlayer = service.updatePlayer(player);
		if (myUpdatedPlayer != null) {
			response.setStatusCode(200);
			response.setMsg("successful");
			response.setDesc("player updated successfully");
			response.setPlayer(myUpdatedPlayer);
		} else {
			response.setStatusCode(400);
			response.setMsg("Failed");
			response.setDesc("Unable to update player");
			response.setPlayer(null);
		}
		return response;
	}

	@GetMapping("/get/{jersey}")
	public PlayerResponse getPlayer(@PathVariable("jersey") int jersey) {
		PlayerResponse response = new PlayerResponse();
		Player myPlayer = service.getPlayer(jersey);
		if (myPlayer != null) {
			response.setStatusCode(200);
			response.setMsg("Successfull");
			response.setDesc("Found the player successfully");
			response.setPlayer(myPlayer);
		} else {
			response.setStatusCode(400);
			response.setMsg("Failed");
			response.setDesc("Unable to find your player");
			response.setPlayer(null);
		}
		return response;
	}

	@DeleteMapping("/delete/{jersey}")
	@ResponseBody
	public PlayerResponse deletePlayer(@PathVariable("jersey") int jersey) {
		PlayerResponse response = new PlayerResponse();
		if (service.deletePlayer(jersey)) {
			response.setStatusCode(200);
			response.setMsg("Successfull");
			response.setDesc("Player deleted successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failed");
			response.setDesc("Unable to delete player");
		}
		return response;
	}
}