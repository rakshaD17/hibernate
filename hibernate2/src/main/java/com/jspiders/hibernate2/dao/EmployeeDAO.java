package com.jspiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate2.dto.EmployeeDTO;

public class EmployeeDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			openConnection();
			
			transaction.begin();
			
			EmployeeDTO employee1 = new EmployeeDTO();
			employee1.setEid(2);
			employee1.setEname("xyz");
			employee1.setEemail("xyz@gmail.com");
			employee1.setEcontact(9876543239L);
			
			manager.persist(employee1);
			
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

}
