package com.cms.been;

public class Course {
    private int courseId;
    private String courseName;
    private double fee;
    private String courseDescription;
    
    public Course(int courseId, String courseName, double fee, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
        this.courseDescription = courseDescription;
    }
    
    public Course() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}