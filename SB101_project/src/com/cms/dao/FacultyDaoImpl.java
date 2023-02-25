package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cms.been.CoursePlan;
import com.cms.been.Faculty;

 public class FacultyDaoImpl implements FacultyDao {

    private Connection connection;

    public FacultyDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public FacultyDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Faculty login(String username, String password) {
        try {
            String query = "SELECT * FROM Faculty WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int facultyId = resultSet.getInt("facultyid");
                String facultyName = resultSet.getString("facultyname");
                String facultyAddress = resultSet.getString("facultyaddress");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");
                Faculty faculty = new Faculty(facultyId, facultyName, facultyAddress, mobile, email, username, password);
                return faculty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePassword(int facultyId, String password) {
        try {
            String query = "UPDATE Faculty SET password = ? WHERE facultyid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, password);
            statement.setInt(2, facultyId);
            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CoursePlan> getAllCoursePlans(int facultyId) {
        List<CoursePlan> coursePlans = new ArrayList<>();
        try {
            String query = "SELECT * FROM CoursePlan WHERE facultyid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, facultyId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int planId = resultSet.getInt("planid");
                int batchId = resultSet.getInt("batchid");
                int dayNumber = resultSet.getInt("daynumber");
                String topic = resultSet.getString("topic");
//                boolean status = resultSet.getString("status");
                boolean status = false;
				if(resultSet.getInt("status")==1) {
					status = true;
				}
                CoursePlan coursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
                coursePlans.add(coursePlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursePlans;
    }
    @Override
    public boolean updateCoursePlanStatus(int planId, String status) {
        try {
            String query = "UPDATE CoursePlan SET status = ? WHERE planid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, status);
            statement.setInt(2, planId);
            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	

	@Override
	public boolean fillDaywisePlanner(int planId, String topic, String status) {
		// TODO Auto-generated method stub
		 try {
		        String query = "INSERT INTO CoursePlan (planid, topic, status) VALUES (?, ?, ?)";
		        PreparedStatement statement = connection.prepareStatement(query);
		        statement.setInt(1, planId);
		        statement.setString(2, topic);
		        statement.setString(3, status);
		        int rowsInserted = statement.executeUpdate();
		        if (rowsInserted > 0) {
		            return true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
	}

	@Override
	public CoursePlan getCoursePlan(int planid) {
		// TODO Auto-generated method stub
		CoursePlan coursePlan = null;
		 try {
	            String query = "SELECT * FROM CoursePlan WHERE planid = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, planid);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                int planId = resultSet.getInt("planid");
	                int batchId = resultSet.getInt("batchid");
	                int dayNumber = resultSet.getInt("daynumber");
	                String topic = resultSet.getString("topic");
//	                boolean status = resultSet.getString("status");
	                boolean status = false;
					if(resultSet.getInt("status")==1) {
						status = true;
					}
	                 coursePlan = new CoursePlan(planId, batchId, dayNumber, topic, status);
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return coursePlan;
	}

}

