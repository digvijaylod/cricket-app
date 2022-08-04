package com.del.cricketapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Player 
{
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String playerName;
	   
    @JsonProperty("country")
    private String country;
 

}
