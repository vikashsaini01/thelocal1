package com.locals.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.locals.entity.Task;
import com.locals.entity.UserInfo;
import com.locals.service.UserInfoImpl;
import com.locals.social.FBConnection;
import com.locals.social.FBGraph;
import com.locals.social.GoogleConnection;
import com.locals.social.GoogleGraph;

@Controller
public class LoginController {
	static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	UserInfoImpl userInfoImpl;

	@RequestMapping("/fbhome")
	public ModelAndView fbhome(@RequestParam("code") String code, HttpSession session) throws Exception {
		UserInfo userInfo = null;
		if (code == null || code.isEmpty() || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		String accessToken = FBConnection.getAccessToken(code);
		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		userInfo = userInfoImpl.validateLogin(fbProfileData.get("userName"), fbProfileData.get("password"));
		if (userInfo == null)
			userInfo = userInfoImpl.addUser(fbProfileData);

		session.setAttribute("UserInfo", userInfo);
		return new ModelAndView("index", "UserInfo", userInfo);
	}

	@RequestMapping("/googlehome")
	public ModelAndView googleHome(@RequestParam("code") String code, HttpSession session, ModelAndView modelAndView) throws Exception {
		UserInfo userInfo = null;
		if (code == null || code.isEmpty() || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		String accessToken = GoogleConnection.getGoogleAccessToekn(code);
		GoogleGraph googleGraph = new GoogleGraph();
		String graph = googleGraph.getGoogleGraph(accessToken);
		Map<String, String> googleProfileData = googleGraph.getGraphData(graph);
		userInfo = userInfoImpl.validateLogin(googleProfileData.get("userName"), googleProfileData.get("password"));
		if (userInfo == null)
			userInfo = userInfoImpl.addUser(googleProfileData);
		session.setAttribute("UserInfo", userInfo);
		modelAndView.addObject("UserInfo", userInfo);
		modelAndView.addObject("Task", new Task());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/*.jsp")
	public ModelAndView home() {
		logger.debug(new Object() {
		}.getClass().getEnclosingMethod().getName());
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {		
		return new ModelAndView("login");
	}

}
