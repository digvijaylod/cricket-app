package com.del.cricketapp.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;

import com.del.cricketapp.model.Player;
import com.del.cricketapp.model.PlayerData;
import com.del.cricketapp.model.PlayerStatistics;

public interface IService 
{
	public PlayerStatistics displayPlayerStatistics(Player player) throws MalformedURLException,IOException;
	public PlayerData searchPlayer(String playerName);
	public PlayerData searchPlayerById(String id);
	
}
