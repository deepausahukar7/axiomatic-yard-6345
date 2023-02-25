package com.cms.dao;

import java.util.List;

import com.cms.been.Batch;
import com.cms.been.Course;
import com.cms.been.CoursePlan;
import com.cms.been.Faculty;
import com.cms.exception.AdminException;

public interface AdminDao {
	
	// Login Admin
	public String loginAdmin()throws AdminException;
	// Course
	public String createCourse(Course c)throws AdminException;
	public String updateCourse(Course c)throws AdminException;
	public List<Course> viewCourse()throws AdminException;
	// Batch
	public String createBatch(Batch b)throws AdminException;
	public String updateBatch(Batch b)throws AdminException;
	public List<Batch> viewBatch()throws AdminException;
	// Faculty
	public String createFaculty(Faculty f)throws AdminException;
	public String updateFaculty(Faculty f)throws AdminException;
	public List<Faculty> viewFaculty()throws AdminException;
	// Course Plan
	public String createPlan(CoursePlan p)throws AdminException;
	public String updatePlan(CoursePlan p)throws AdminException;
	public List<CoursePlan> viewPlan()throws AdminException;
	// Allocate Faculty
	public void allocateFaculty()throws AdminException;
	// Batch Wise Report
	public void reportBatch()throws AdminException;
}

