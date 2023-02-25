package com.cms.been;

public class CoursePlan {
    private int planId;
    private int batchId;
    private int dayNumber;
    private String topic;
    private boolean status;
    
    public CoursePlan(int planId, int batchId, int dayNumber, String topic, boolean status) {
        this.planId = planId;
        this.batchId = batchId;
        this.dayNumber = dayNumber;
        this.topic = topic;
        this.status = status;
    }
    
    public CoursePlan() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

