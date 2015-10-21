package com.frank.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.ProjectDAOImpl;
import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class DeleteProjectAction extends ActionSupport {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "deleteProject", results = {
			@Result(name = INPUT, location = "/error.jsp"),
			@Result(name = SUCCESS, location = "/company/companyIndex.jsp") })
		
	public String execute() {
	//	;
		//if (name.equals("steve") && password.equals("123"))
			if(deleteData(name)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return INPUT;}
	}

	private boolean deleteData(String inputName) {
		boolean flag=true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProjectDAOImpl dao = (ProjectDAOImpl) context.getBean("ProjectDAO");
		try{
		dao.delete(dao.findByName(inputName).get(0));}catch(Exception e){
			flag=false;
		}
		
		return flag;
	}
}