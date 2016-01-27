package com.example;


public class Vehicle {
	
	private int id;
	private String model;
	private String manufacture;

	public Vehicle() {
	}
	
	public Vehicle(int id, String model, String manufacture) {
		this.id = id;
		this.model = model;
		this.manufacture = manufacture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
}
