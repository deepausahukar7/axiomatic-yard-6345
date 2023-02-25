package com.cms.usecases;

import java.util.Scanner;

import com.cms.been.Faculty;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class CreateFaculty {
	
	public String facultyCreate() {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Faculty Id: ");
			int fid = sc.nextInt();
			System.out.println("Enter Faculty Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Enter Faculty Address: ");
			String address = sc.nextLine();
			System.out.println("Enter Mobile No. : ");
			String mob = sc.nextLine();
			System.out.println("Enter Email Id: ");
			String email = sc.nextLine();
			System.out.println("Enter Username: ");
			String user = sc.nextLine();
			System.out.println("Enter Password: ");
			String pass = sc.nextLine();
			
			AdminDao dao = new AdminDaoImpl();
			Faculty f = new Faculty(fid, name, address, mob, email, user, pass);
			String res = null;
			try {
				res = dao.createFaculty(f);
			} catch (AdminException e) {
				System.out.println(e.getMessage());
			}
			return res;
		
		
	}

}
