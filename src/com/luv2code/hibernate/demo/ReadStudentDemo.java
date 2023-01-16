package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create the student object
			Student theStud = new Student("Daffy", "Duck", "daffy.duck@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(theStud);
			
			//commit transaction
			session.getTransaction().commit();
			
			//find the students's is: primary key
			System.out.println(theStud.getId());
			
			// get a new session and start transaction. In hibernate, we always need to
			// open a new session and begin the transaction. It is always needed.
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on primary key
			Student myStud = session.get(Student.class, theStud.getId());
			System.out.println(myStud);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}


