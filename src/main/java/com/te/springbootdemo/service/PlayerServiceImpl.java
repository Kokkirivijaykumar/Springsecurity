package com.te.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootdemo.dto.Player;
import com.te.springbootdemo.repo.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepo repo;

	public Player insertPlayer(Player player) {
		Player saved=repo.save(player);
		return saved;
	}

	public Player getPlayer(int jerseyNumber) {
		Optional<Player> player = repo.findById(jerseyNumber);
	Player	myplay=player.get();
	return myplay;
//
//		Optional<Player> optionalPlayer = repo.findById(jerseyNumber);
//		Player myPlayer = optionalPlayer.get();
//		return myPlayer;

	}

	public Player updatePlayer(Player player) {
		Optional<Player> OptionalPlayer = repo.findById(player.getJerseyNumber());
		Player originalPlayer = OptionalPlayer.get();

		if (player.getName() != null && player.getName() != "") {
			originalPlayer.setName(player.getName());
		}
		if (player.getGame() != null && player.getGame() != "") {
			originalPlayer.setGame(player.getGame());
		}
		if (player.getClub() != null && player.getClub() != "") {
			originalPlayer.setClub(player.getClub());
		}
		if (player.getCountry() != null && player.getCountry() != "") {
			originalPlayer.setCountry(player.getCountry());
		}

		Player updatedPlayer = repo.save(originalPlayer);
		return updatedPlayer;
	}

	public boolean deletePlayer(int jersey) {
		boolean isDeleted = false;
		try {
			repo.deleteById(jersey);
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}