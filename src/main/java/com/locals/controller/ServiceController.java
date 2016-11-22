package com.locals.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locals.entity.Task;
import com.locals.entity.UserInfo;
import com.locals.service.TaskImpl;
import com.locals.service.UserInfoImpl;
import com.locals.social.FBConnection;
import com.locals.social.FBGraph;

@Controller
public class ServiceController {
	static Logger logger = Logger.getLogger(ServiceController.class);

	@Autowired
	UserInfoImpl userInfoImpl;
	
	@Autowired
	TaskImpl taskImpl;

	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public ModelAndView addtask(HttpSession session, @ModelAttribute("Task") Task task, BindingResult result, Model model) throws Exception {

		String owner = ((UserInfo)session.getAttribute("UserInfo")).getId();
		Date createdDate =  new Date();
		task.setTaskId( owner + createdDate.getTime())  ;
		task.setOwner(owner);
		task.setCreatedDate(createdDate);		
		taskImpl.addTask(task);
		
		return new ModelAndView("index", "Task", task);
	}
}
