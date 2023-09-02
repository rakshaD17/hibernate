package com.jspiders.hibernateonetomany.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class SchoolDTO {

	@Id
	private int id;
	private String name;
	private String addresss;
	@OneToOne
	private List<StudentDTO> students;
	
}
