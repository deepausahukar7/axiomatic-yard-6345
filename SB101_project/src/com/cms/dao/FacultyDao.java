package com.cms.dao;

import java.util.List;

import com.cms.been.CoursePlan;
import com.cms.been.Faculty;

public interface FacultyDao {
    
    public Faculty login(String username, String password);
    
    public CoursePlan getCoursePlan(int planId);
    
    public List<CoursePlan> getAllCoursePlans(int FacultyId);
    
    public boolean fillDaywisePlanner(int planId, String topic, String status);
    
    public boolean updatePassword(int facultyId, String password);

	boolean updateCoursePlanStatus(int planId, String status);
}
