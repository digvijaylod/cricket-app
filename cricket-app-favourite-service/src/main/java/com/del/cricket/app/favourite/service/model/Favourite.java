package com.del.cricket.app.favourite.service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Favourite {
	@Id
	private String id;	
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
