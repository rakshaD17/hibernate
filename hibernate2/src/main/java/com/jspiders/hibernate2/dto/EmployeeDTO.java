package com.jspiders.hibernate2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeDTO {

	@Id
	private int Eid;
	private String Ename;
	private String Eemail;
	private long Econtact;
}
