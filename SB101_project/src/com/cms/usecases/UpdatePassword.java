package com.cms.usecases;

import com.cms.dao.FacultyDao;
import com.cms.exception.FacultyException;

import java.util.Scanner;

import com.cms.dao.*;
public class UpdatePassword {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter FacultyId :");
		int facultyId = sc.nextInt();
		System.out.println("Enter Password :");
		String password = sc.next();
		FacultyDao dao = new FacultyDaoImpl();
		try {
			boolean res = dao.updatePassword(facultyId,password);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}