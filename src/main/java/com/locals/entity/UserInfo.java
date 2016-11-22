package com.locals.entity;

import java.util.Map;

public class UserInfo {
	private String id;
	private String userName;
	private String password;
	private String emailId;
	private String primaryLanguage;
	private String loginType;
	
	public static UserInfo getUserInfo(Map<String, String> map){
		UserInfo userInfo = new UserInfo() ; 
		userInfo.setId(map.get("id"));
		userInfo.setEmailId(map.get("emailId"));
		userInfo.setLoginType(map.get("loginType"));
		userInfo.setPassword(map.get("password"));
		userInfo.setPrimaryLanguage(map.get("primaryLanguage"));
		userInfo.setUserName(map.get("userName"));
		return userInfo;
	}
	
	public UserInfo(){}
	
	/**
	 * 
	 * @param id
	 * @param userName
	 * @param password
	 * @param emailId
	 * @param primaryLanguage
	 * @param loginType
	 */
	public UserInfo(String id, String userName, String password, String emailId, String primaryLanguage,
			String loginType) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.primaryLanguage = primaryLanguage;
		this.loginType = loginType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPrimaryLanguage() {
		return primaryLanguage;
	}
	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}