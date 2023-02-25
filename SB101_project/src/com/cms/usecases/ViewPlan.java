package com.cms.usecases;

import java.util.List;

import com.cms.been.CoursePlan;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class ViewPlan {
	
	public void planView() {
		
		System.out.println();
		AdminDao dao = new AdminDaoImpl();
		try {
			List<CoursePlan> plan = dao.viewPlan();
			plan.forEach(p -> System.out.println(p));
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}

}
