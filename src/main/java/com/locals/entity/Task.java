package com.locals.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASKS1")
public class Task {
	 
	@Id
	String taskId;
	String owner;
	Date createdDate;
	String summary;
	String description;
	Date targetdate;
	Date completeddate;
	Date deleted;
	String parenttask;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(Date targetdate) {
		this.targetdate = targetdate;
	}

	public Date getCompleteddate() {
		return completeddate;
	}

	public void setCompleteddate(Date completeddate) {
		this.completeddate = completeddate;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public String getParenttask() {
		return parenttask;
	}

	public void setParenttask(String parenttask) {
		this.parenttask = parenttask;
	}

}
