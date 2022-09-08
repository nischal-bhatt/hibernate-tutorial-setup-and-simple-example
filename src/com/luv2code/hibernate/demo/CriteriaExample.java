package com.luv2code.hibernate.demo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration()
	             .configure("hibernate.cfg.xml")
	             .addAnnotatedClass(Student.class)
	             .buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
	    Root<Student> root = criteriaQuery.from(Student.class);
	    criteriaQuery.select(root);
	    
	    Query<Student> query =session.createQuery(criteriaQuery);
	    List<Student> students = query.list();
	    
	    students.forEach(System.out::println);
	    fac.close();
	    
	}

}
