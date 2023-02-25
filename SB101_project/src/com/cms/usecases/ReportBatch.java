package com.cms.usecases;

import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class ReportBatch {
	
	public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		try {
			dao.reportBatch();
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
	}

}