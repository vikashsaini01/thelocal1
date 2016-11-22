package com.locals.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locals.dao.UserInfoDao;
import com.locals.entity.UserInfo;

@Service
public class UserInfoImpl {
	@Autowired
	UserInfoDao userInfoDao;

	public UserInfo validateLogin(String username, String password) throws Exception {
		return userInfoDao.getUserInfo(username, password);
		
	}

	public UserInfo addUser(Map<String,String> fbProfileData)throws Exception {
		
		return userInfoDao.addUserInfo(UserInfo.getUserInfo(fbProfileData));
	}

	public static void main(String[] ar) throws Exception {
		UserInfoImpl userInfoImpl = new UserInfoImpl();
		userInfoImpl.userInfoDao = new UserInfoDao();
		userInfoImpl.validateLogin("vikash", "vikas");
	}

}
