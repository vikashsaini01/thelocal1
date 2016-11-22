package com.locals.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.locals.entity.UserInfo;
import com.locals.utils.SqlConnection;
@Repository
public class UserInfoDao {
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
	
	
	
	public UserInfo addUserInfo(UserInfo userInfo) throws Exception{
		PreparedStatement preparedStatement =
				SqlConnection.getConnection().prepareStatement("Insert into userinfo (id, username, password, emailid, logintype) values (?, ? , ? , ?, ?)");
		preparedStatement.setString(1, userInfo.getId());
		preparedStatement.setString(2, userInfo.getUserName());
		preparedStatement.setString(3, userInfo.getPassword());
		preparedStatement.setString(4, userInfo.getEmailId());
		preparedStatement.setString(5, userInfo.getLoginType());
		int rowsAffected = preparedStatement.executeUpdate();
		if(rowsAffected == 1)
		{
			return userInfo;
		}
		return null;
	}
}
