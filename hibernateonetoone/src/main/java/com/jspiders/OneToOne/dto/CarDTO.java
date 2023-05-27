package com.jspiders.OneToOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CarDTO {

	@Id
	private int id;
	private String brand;
	private String model;
	private String regno;
	@OneToOne
	private DriverDTO driver;
}
