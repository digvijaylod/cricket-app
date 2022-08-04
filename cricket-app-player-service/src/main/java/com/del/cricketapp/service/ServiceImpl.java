package com.del.cricketapp.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.del.cricketapp.model.Player;
import com.del.cricketapp.model.PlayerData;
import com.del.cricketapp.model.PlayerStatistics;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceImpl implements IService
{
	@Autowired
	RestTemplate playerClient;
	
	@Value("${playerSearchUrl}")
	private String playerSearchUrl;
	
	@Value("${playerStatsUrl}")
	private String playerStatsUrl;
	
	@Value("${playerSearchByIdUrl}")
	private String playerSearchByIdUrl;

	@Override
	public PlayerStatistics displayPlayerStatistics(Player player) throws IOException {
		String playerId = player.getId();
		System.out.println(playerId);
		
		
URL url = new URL(playerStatsUrl+playerId);
		
		JsonNode node = new ObjectMapper().readTree(url);
		
		String id = node.get("data").get("id").textValue();
		String name = node.get("data").get("name").textValue();
		String country = node.get("data").get("country").textValue();
		String role = node.get("data").get("role").textValue();
		String battingStyle = node.get("data").get("battingStyle").textValue();
		String bowlingStyle = node.get("data").get("bowlingStyle").textValue();
		String playerImg = node.get("data").get("playerImg").textValue();
		
		PlayerStatistics data = new PlayerStatistics(id,name,country,role,battingStyle,bowlingStyle,playerImg);
		//PlayerStatisticsData playerStatsData = playerClient.getForEntity(playerStatsUrl+id,PlayerStatisticsData.class).getBody();
		
		return data;
	
	}
	

	@Override
	public PlayerData searchPlayer(String playerName) {
		return  playerClient.getForObject(playerSearchUrl+playerName, PlayerData.class);
	}


	@Override
	public PlayerData searchPlayerById(String id) {
		return playerClient.getForObject(playerSearchByIdUrl+id, PlayerData.class);
	}
}
	
	
	


