package com.frank.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class PersonLoginHandleAction extends ActionSupport {

private String type;

	public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
	@Action(value = "loginHandle", results = {
			@Result(name = INPUT, location = "/login/login.jsp"),
			@Result(name = SUCCESS, location = "/login/companyLogin.jsp") })
		
	public String execute() {
		if(type.equalsIgnoreCase("company")){
			return SUCCESS;
		}else{return INPUT;}

	}

}