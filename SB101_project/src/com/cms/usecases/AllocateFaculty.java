package com.cms.usecases;

import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class AllocateFaculty {
	
	public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		try {
			dao.allocateFaculty();
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}