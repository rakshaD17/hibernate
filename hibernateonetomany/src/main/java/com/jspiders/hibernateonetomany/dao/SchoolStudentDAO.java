package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.SchoolDTO;
import com.jspiders.hibernateonetomany.dto.StudentDTO;

public class SchoolStudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
      factory = Persistence.createEntityManagerFactory("OneToMany");
	  manager = factory.createEntityManager();
	  transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		transaction.begin();
		
		SchoolDTO school = new SchoolDTO();
		school.setName("ABC");
		school.setAddresss("pune");
		
		StudentDTO student1 = new StudentDTO();
		student1.setName("ram");
		student1.setEmail("ram@gmail.com");
		
		StudentDTO student2 = new StudentDTO();
		student2.setName("bharat");
		student2.setEmail("bharat@gmail.com");
		
		school.setStudents(Arrays.asList(student2, student2));
		
		manager.persist(student1);
		manager.persist(student2);
		manager.persist(school);
		
		transaction.commit();
		closeConnection();
		
		
	}

}
