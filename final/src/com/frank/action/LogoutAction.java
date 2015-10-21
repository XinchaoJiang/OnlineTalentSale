package com.frank.action;

import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.UserDAOImpl;
import com.frank.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class LogoutAction extends ActionSupport {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Action(value = "logout", results = {
			@Result(name = INPUT, location = "error.jsp"),
			@Result(name = SUCCESS, location ="/index.jsp") })		
	public String execute() {
	//	;
		//if (name.equals("steve") && password.equals("123"))
		try{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		session.setAttribute("name", "");
		session.setAttribute("role", "");
		session.invalidate();
		return SUCCESS;
		}catch(Exception e){
			return INPUT;
		}

	}

	
	
}