package com.locals.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.locals.entity.Task;
import com.locals.entity.UserInfo;
import com.locals.utils.SqlConnection;
@Repository
public class TaskDao {
	
	public UserInfo getUserInfo(String username, String password)throws Exception{
		PreparedStatement preparedStatement =
				SqlConnection.getConnection().prepareStatement("Select * from userinfo where username =? and (password =  ? OR (password IS NULL AND ? IS NULL))");		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, password);
		ResultSet resultSet = preparedStatement.executeQuery(); 

		if(resultSet.next()){
			UserInfo userInfo =new UserInfo(resultSet.getString("id"), resultSet.getString("username"), resultSet.getString("password"),  resultSet.getString("emailid"),  resultSet.getString("primarylanguage"),  resultSet.getString("logintype"));
			return userInfo;
		}
		return null;
	}
	
	
	
	public Task addTask(Task task) throws Exception{
		PreparedStatement preparedStatement =
				SqlConnection.getConnection().prepareStatement("Insert into Tasks (taskid, owner, createddate, summary, description, targetdate, completeddate, deleted, parenttask) values (?,?,?,?,?,?,?,?,?)");
		preparedStatement.setString(1, task.getTaskId());
		preparedStatement.setString(2, task.getOwner());
		preparedStatement.setDate(3, new Date(task.getCreatedDate().getTime()));
		preparedStatement.setString(4, task.getSummary());
		preparedStatement.setString(5, task.getDescription());
		preparedStatement.setDate(6, (task.getTargetdate()== null)? null : new Date(task.getTargetdate().getTime()));
		preparedStatement.setDate(7, (task.getCompleteddate()== null) ? null : new Date(task.getCompleteddate().getTime()));
		preparedStatement.setDate(8, (task.getDeleted()==null)? null : new Date(task.getDeleted().getTime()));
		preparedStatement.setString(9, task.getParenttask());
		
		int rowsAffected = preparedStatement.executeUpdate();
		if(rowsAffected == 1)
		{
			return task;
		}
		return null;
	}



	public List<Task> getTasks(String userId)throws Exception {
		PreparedStatement preparedStatement =
				SqlConnection.getConnection().prepareStatement("select * from Tasks where owner = ?");
		preparedStatement.setString(1, userId);		
		ResultSet rs  = preparedStatement.executeQuery();
		
		
		
	}
}
