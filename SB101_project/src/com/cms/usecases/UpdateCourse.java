package com.cms.usecases;

import java.util.Scanner;

import com.cms.been.Course;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class UpdateCourse {
	
	public String courseUpadate() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Course Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Fee: ");
		int fee = sc.nextInt();
		System.out.print("Enter Course Description: ");
		sc.nextLine();
		String cd = sc.nextLine();
		System.out.println("Enter Course Id: ");
		int id = sc.nextInt();
	
		Course c = new Course(id, name, fee, cd);
		AdminDao dao = new AdminDaoImpl();
		String res = null;
		try {
			res = dao.updateCourse(c);
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}

}
