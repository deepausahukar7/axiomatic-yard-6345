package com.cms.usecases;

import java.util.Scanner;

import com.cms.been.Admin;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;



public class AdminLogin {
	
	public String loginAdmin() {
		String res = "";
		AdminDao dao = new AdminDaoImpl();
		try {
			res = dao.loginAdmin();
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return res;		
	}

}
