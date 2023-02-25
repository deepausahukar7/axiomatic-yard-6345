package com.cms.usecases;

import java.util.Scanner;

import com.cms.been.Faculty;
import com.cms.dao.FacultyDao;
import com.cms.dao.FacultyDaoImpl;
import com.cms.exception.FacultyException;

public class LoginFaculty {
	
	public boolean facultyLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Usename:");
		String username = sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();
		boolean c = false;
		FacultyDao dao = new FacultyDaoImpl();
		try {
			Faculty res = dao.login(username,password);
			System.out.println(res);
			c = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
		
	}

}