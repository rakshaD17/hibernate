package com.jspiders.hibernateonetomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class TeamDTO {

	@Id
	private int id;
	private String name;
	private String coach;
	private String city;
	@OneToMany
	private List<PlayerDTO> players;

}
