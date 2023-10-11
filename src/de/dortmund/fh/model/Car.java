package de.dortmund.fh.model;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 5701132957522998226L;
	private String id;
	private String make;
	private String model;
	private int yearOfManufacture;
	private String color;
	private int price;
	private String registrationNumber;

	public Car(String id, String make, String model, int yearOfManufacture, String color, int price,
			String registrationNumber) {

		this.id = id;
		this.make = make;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.color = color;
		this.price = price;
		this.registrationNumber = registrationNumber;
	}

	public String getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public String getColor() {
		return color;
	}

	public int getPrice() {
		return price;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

}
