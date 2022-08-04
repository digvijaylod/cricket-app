package com.del.cricket.app.favourite.service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlayerData 
{
	@JsonProperty("data")
	private List<Player> data;

}
