package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false";
		String user = "root";
		String pass = "root";
		
		try {
			
			System.out.println("connecting to db " + jdbcUrl);
			
			Connection myConn 
			= DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("connection successful");
			
			
			
		}catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}

}
