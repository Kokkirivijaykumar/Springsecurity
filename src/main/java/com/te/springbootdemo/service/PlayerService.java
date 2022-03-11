package com.te.springbootdemo.service;

import com.te.springbootdemo.dto.Player;

public interface PlayerService {

	public Player insertPlayer(Player player);
	
	public Player getPlayer(int jerseyNumber);
	
	public Player updatePlayer(Player player);
	
	public boolean deletePlayer(int jersey);
	
}