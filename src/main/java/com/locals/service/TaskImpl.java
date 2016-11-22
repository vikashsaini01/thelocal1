package com.locals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locals.dao.TaskDao;
import com.locals.entity.Task;

@Service
public class TaskImpl {
	@Autowired
	TaskDao taskDao;

	public Task addTask(Task task) throws Exception {

		return taskDao.addTask(task);
	}
	
	public List<Task> getTasks(String userId) throws Exception {

		return taskDao.getTasks(userId);
	}

}
