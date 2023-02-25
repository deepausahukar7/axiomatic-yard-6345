package com.cms.usecases;

import java.util.Scanner;

import com.cms.been.Course;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class CreateCourse {
	
	public String courseCreate() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Course Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Course Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter Fee: ");
		Double fee = sc.nextDouble();
		System.out.println("Enter Course Descreption: ");
		sc.nextLine();
		String cd = sc.nextLine();
		
		Course c = new Course(id, name, fee, cd);
		AdminDao dao = new AdminDaoImpl();
		String res = null;
		try {
			res = dao.createCourse(c);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}

}
