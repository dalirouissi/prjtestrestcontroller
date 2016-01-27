package com.example;

public class Tank {
	
	
	private long identifier;
	private String description;

	public Tank(long identifier, String description) {
		this.identifier = identifier;
		this.description = description;
	}
	
	public long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
