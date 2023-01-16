package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId=1;
			//start a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setEmail("deffi.deffi@gmail.com");			
			
			// commit the transaction
			session.getTransaction().commit();
			
		}
		
		finally {
			factory.close();
		}
	}

}


