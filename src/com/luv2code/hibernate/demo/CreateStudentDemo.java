package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory fac = new Configuration()
				             .configure("hibernate.cfg.xml")
				             .addAnnotatedClass(Student.class)
				             .buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		
		try {
			Student temp = new Student("raz","deen","singh@email.com");
			session.beginTransaction();
			session.save(temp);
			session.getTransaction().commit();
			
		}finally {
			fac.close();
		}
		
	}

}
