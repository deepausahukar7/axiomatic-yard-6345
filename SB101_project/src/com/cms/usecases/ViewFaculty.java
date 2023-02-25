package com.cms.usecases;

import java.util.List;

import com.cms.been.Faculty;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class ViewFaculty {
	
	public void facultyView() {
		
		System.out.println();
		AdminDao dao = new AdminDaoImpl();
		try {
			List<Faculty> faculty = dao.viewFaculty();
			faculty.forEach(f -> System.out.println(f));
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}

}
