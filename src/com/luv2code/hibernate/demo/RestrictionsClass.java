package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.luv2code.hibernate.demo.entity.Student;

public class RestrictionsClass {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration()
	             .configure("hibernate.cfg.xml")
	             .addAnnotatedClass(Student.class)
	             .buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		session.beginTransaction();
		Criteria ctr = session.createCriteria(Student.class);
		//Criterion c1 = Restrictions.ne("firstName", "laalu prasad");
		Criterion c1 = Restrictions.idEq(8);
		ctr.add(c1);
		System.out.println("-------------here printing start");
		List<Student> list = ctr.list();
		System.out.println("-------------here printing end");
		for (int i =0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getFirstName() + " is here");
		}
		
		session.close();
	    fac.close();
	    
	}

}
