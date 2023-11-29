package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.StudentDTO;

public class studentDAO {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		StudentDTO student1 = new StudentDTO();
		student1.setSid(1);
		student1.setSname("raksha");
		student1.setSemail("raksha@gmail.com");
		student1.setScontact(918298091);
		student1.setScity("pune");
		
		manager.persist(student1);
		
		transaction.commit();
		
		if(factory!=null);
		{
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
}
