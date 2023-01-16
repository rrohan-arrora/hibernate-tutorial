package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml") // there is no need to mention the file name, it works that way as well
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create the student object
			Student theStudent = new Student("rohan", "arora", "rohan.arora@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}
	}

}


