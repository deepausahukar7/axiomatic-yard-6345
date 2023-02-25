package com.cms.usecases;

import java.util.List;

import com.cms.been.Course;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class ViewCourse {
	
	public void courseView() {
		
		System.out.println();
		AdminDao dao = new AdminDaoImpl();
		try {
			List<Course> course = dao.viewCourse();
			course.forEach(C -> System.out.println(C));
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}

}
