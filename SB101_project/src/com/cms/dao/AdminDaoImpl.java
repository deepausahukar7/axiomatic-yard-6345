package com.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cms.been.Admin;
import com.cms.been.Allocate;
import com.cms.been.Batch;
import com.cms.been.Course;
import com.cms.been.CoursePlan;
import com.cms.been.Faculty;
import com.cms.been.Report;
import com.cms.exception.AdminException;
import com.cms.utility.DbUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String loginAdmin() throws AdminException{
		String massage = "Invalid Username or Password";
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("select * from admin");
			ResultSet rs = ps.executeQuery();
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter Username: ");
				String userid = sc.next();
				System.out.print("Enter Password: ");
				String password = sc.next();
				Admin ad = null;
				while(rs.next()) {
					String user = rs.getString("username");
					String pass = rs.getString("password");
					ad = new Admin(user, pass);
				}
				if(ad.getUsername().equals(userid) && ad.getPassword().equals(password)) {
					massage = "Sign in Succesfull !..";
				}else {
					massage = "Invalid Username of Password";
				}
		} catch (SQLException e) {
			throw new AdminException("Invalid Username or Password");
		}
		return massage;
	}

	public String createCourse(Course c)throws AdminException {
		String massage = "Course can't be Created Please try again..";
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("insert into course values(?, ?, ?, ?)");
			ps.setInt(1, c.getCourseId());
			ps.setString(2, c.getCourseName());
			ps.setDouble(3, c.getFee());
			ps.setString(4, c.getCourseDescription());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Course Added Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Course can't be Created Please try again..");
		}
		return massage;
	}
	
	public String updateCourse(Course c)throws AdminException {
		String massage = "Course can't be Updated Please try again..";
				
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("update course set courseName = ?, fee = ?, courseDescription = ? where courseid = ?");
			ps.setString(1, c.getCourseName());
			ps.setDouble(2, c.getFee());
			ps.setString(3, c.getCourseDescription());
			ps.setInt(4, c.getCourseId());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Course Updated Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Course can't be Updated Please try again..");
		}
		return massage;
	}

	@Override
	public List<Course> viewCourse() throws AdminException {
		List<Course> course = new ArrayList<>();
		try (Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("select * from course");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("courseid");
				String name = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String cd = rs.getString("courseDescription");
				
				course.add(new Course(id, name, fee, cd));
			}
		} catch (SQLException e) {
			throw new AdminException("You can't see the course Please try again..");
		}
		return course;
	}

	@Override
	public String createBatch(Batch b) throws AdminException {
		String massage = "Batch can't be Created Please try again..";
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("insert into batch values(?, ?, ?, ?, ?, ?)");
			ps.setInt(1, b.getBatchId());
			ps.setInt(2, b.getCourseId());
			ps.setInt(3, b.getFacultyId());
			ps.setInt(4, b.getNumberOfStudents());
			ps.setString(5, b.getBatchStartDate().toString());
			ps.setInt(6, b.getDuration());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Batch Added Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Batch can't be Created Please try again..");
		}
		return massage;
	}

	@Override
	public String updateBatch(Batch b) throws AdminException {
		String massage = "Batch can't be Updated Please try again..";
		
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("update batch set courseId = ?, facultyId = ?, batchStartDate = ?, duration = ? where batchId = ?");
			ps.setInt(1, b.getCourseId());
			ps.setInt(2, b.getFacultyId());
			ps.setInt(3, b.getNumberOfStudents());
			ps.setString(4, b.getBatchStartDate().toString());
			ps.setInt(5, b.getDuration());
			ps.setInt(6, b.getBatchId());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Batch Updated Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Batch can't be Updated Please try again..");
		}
		return massage;
	}

	@Override
	public List<Batch> viewBatch() throws AdminException {
		List<Batch> batch = new ArrayList<>();
		try (Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("select * from batch");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("batchid");
				int cid = rs.getInt("courseid");
				int fid = rs.getInt("facultyid");
				int nos = rs.getInt("numberOfStudents");
				Date date = rs.getDate("batchStartDate");
				int duration = rs.getInt("duration");
				
				batch.add(new Batch(bid, cid, fid, nos, date, duration));
			}
		} catch (SQLException e) {
			throw new AdminException("You can't see the Batch Please try again..");
		}
		return batch;
	}

	@Override
	public String createFaculty(Faculty f) throws AdminException {
		String massage = "Faculty can't be Created Please try again..";
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("insert into faculty values(?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, f.getFacultyid());
			ps.setString(2, f.getFacultyname());
			ps.setString(3, f.getFacultyaddress());
			ps.setString(4, f.getMobile());
			ps.setString(5, f.getEmail());
			ps.setString(6, f.getPassword());
			ps.setString(7, f.getUsername());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Faculty Added Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Faculty can't be Created Please try again..");
		}
		return massage;
	}

	@Override
	public String updateFaculty(Faculty f) throws AdminException {
		String massage = "Faculty can't be Updated Please try again..";
		
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("update faculty set facultyName = ?, facultyAddress = ?, mobile = ?, email = ?, password = ?, username = ? where facultyid = ?");
			ps.setString(1, f.getFacultyname());
			ps.setString(2, f.getFacultyaddress());
			ps.setString(3, f.getMobile());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getPassword());
			ps.setString(6, f.getUsername());
			ps.setInt(7, f.getFacultyid());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Faculty Updated Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Faculty can't be Updated Please try again..");
		}
		return massage;
	}

	@Override
	public List<Faculty> viewFaculty() throws AdminException {
		List<Faculty> faculty = new ArrayList<>();
		try (Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("select * from faculty");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("facultyid");
				String fname = rs.getString("facultyName");
				String fadd = rs.getString("facultyAddress");
				String fmob = rs.getString("mobile");
				String femail = rs.getString("email");
				String fpass = rs.getString("password");
				String fuser = rs.getString("username");
				
				faculty.add(new Faculty(fid, fname, fmob, fadd, femail, fuser, fpass));
			}
		} catch (SQLException e) {
			throw new AdminException("You can't see the Batch Please try again..");
		}
		return faculty;
	}

	@Override
	public String createPlan(CoursePlan p) throws AdminException {
		String massage = "Course Plan can't be Created Please try again..";
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("insert into courseplan values(?, ?, ?, ?, ?)");
			ps.setInt(1, p.getPlanId());
			ps.setInt(2, p.getBatchId());
			ps.setInt(3, p.getDayNumber());
			ps.setString(4, p.getTopic());
			if(p.getStatus()) {
				ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Course Plan Added Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Course plan can't be Created Please try again..");
		}
		return massage;
	}

	@Override
	public String updatePlan(CoursePlan p) throws AdminException {
		String massage = "Course Plan can't be Updated Please try again..";
		
		try(Connection conn = DbUtil.ConnectionProvider()) {
			PreparedStatement ps = conn.prepareStatement("update courseplan set batchid = ?, daynumber = ?, topic = ?, status = ? where planid = ?");
			ps.setInt(2, p.getBatchId());
			ps.setInt(3, p.getDayNumber());
			ps.setString(4, p.getTopic());
			if(p.getStatus()) {
				ps.setInt(5, 1);
			}else {
				ps.setInt(5, 0);
			}
			ps.setInt(1, p.getPlanId());
			
			int x = ps.executeUpdate();
			if(x>0) {
				massage = "Course Plan Updated Succesfully !...";
			}
		} catch (SQLException e) {
			throw new AdminException("Course Plan can't be Updated Please try again..");
		}
		return massage;
	}

	@Override
	public List<CoursePlan> viewPlan() throws AdminException {
		List<CoursePlan> plan = new ArrayList<>();
		try (Connection conn = DbUtil.ConnectionProvider()){
			PreparedStatement ps = conn.prepareStatement("select * from courseplan");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("planid");
				int bid = rs.getInt("batchid");
				int dan = rs.getInt("daynumber");
				String topic = rs.getString("topic");
				boolean st = false;
				if(rs.getInt("status")==1) {
					st = true;
				}
				plan.add(new CoursePlan(pid, bid, dan, topic, st));
			}
		} catch (SQLException e) {
			throw new AdminException("You can't see the Course Plan Please try again..");
		}
		return plan;
	}

	@Override
	public void allocateFaculty() throws AdminException {
		List<Allocate> all = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Faculty Name: ");
		String fname = sc.nextLine();
		try (Connection conn = DbUtil.ConnectionProvider()){
			PreparedStatement ps = conn.prepareStatement("select f.facultyid, f.facultyname, b.batchid, b.numberOfStudents, c.courseid, c.coursename from (( batch b inner join faculty f on b.facultyid = f.facultyid ) inner join course c on b.courseid = c.courseid) where f.facultyname = ?");
			ps.setString(1, fname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("facultyid");
				String fname1 = rs.getString("facultyname");
				int bid = rs.getInt("batchid");
				int nos = rs.getInt("numberOfStudents");
				int cid = rs.getInt("courseid");
				String cname = rs.getString("coursename");
				all.add(new Allocate(fid, fname1, bid, nos, cid, cname));
			}
		} catch (SQLException e) {
			throw new AdminException("Failed");
		}
		all.forEach(a -> System.out.println(a));
	}

	@Override
	public void reportBatch() throws AdminException {
		List<Report> r = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Id: ");
		int bid = sc.nextInt();
		try (Connection conn = DbUtil.ConnectionProvider()){
			PreparedStatement ps = conn.prepareStatement("select b.batchid, f.facultyid, f.facultyname, b.numberOfStudents, c.courseid, c.coursename, c.fee from (( batch b inner join faculty f on b.facultyid = f.facultyid ) inner join course c on b.courseid = c.courseid) where b.batchid = ?");
			ps.setInt(1, bid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int batchid = rs.getInt("batchid");
				int facultyid = rs.getInt("facultyid");
				String facultyname = rs.getString("facultyname");
				int numberOfStudents = rs.getInt("numberOfStudents");
				int courseid = rs.getInt("courseid");
				String coursename = rs.getString("coursename");
				int fee = rs.getInt("fee");
				
				r.add(new Report(batchid, facultyid, facultyname, numberOfStudents, courseid, coursename, fee));
			}
		} catch (SQLException e) {
			throw new AdminException("Failed");
		}
		r.forEach(a -> System.out.println(a));
	}
	
	
}