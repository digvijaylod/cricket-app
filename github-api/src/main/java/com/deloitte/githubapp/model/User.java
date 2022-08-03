package com.deloitte.githubapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("login")
	private String username;
	
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("company")
    private String company;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("email")
    private String email;

    @JsonProperty("public_repos")
    private int numOfPublicRepos;

    @JsonProperty("followers")
    private int numOfFollowers;

    @JsonProperty("following")
    private int numFollowing;

}
