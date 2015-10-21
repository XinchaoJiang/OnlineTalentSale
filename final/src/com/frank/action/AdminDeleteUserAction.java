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
import com.frank.impl.UserDAOImpl;
import com.frank.model.Project;
import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class AdminDeleteUserAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "adminDeleteUser", results = {
			@Result(name = INPUT, location = "/admin/deleteUsers.jsp"),
			@Result(name = SUCCESS, location = "/admin/deleteUsers.jsp"), 
			@Result(name=ERROR, location="/error.jsp")})
		
	public String execute() {
		if(name==null){
			getData();	
			return INPUT;}else{				
			}
				try {
					if(deleteData(name)){
						System.out.println("aaaaa");
						getData();
					return SUCCESS;}

					else{
						getData();

						return INPUT;
						}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
		

	}

	private void getData(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		UserDAOImpl dao = (UserDAOImpl) context.getBean("UserDAO");
		System.out.println("find");
		List<User> list = dao.findAll();
		System.out.println("find done");
		int n = list.size();
		System.out.println(n);
		if(n==0){
			System.out.println("no object return!");}
		   request.setAttribute("adminUsers", list);
		
	}
	
	private boolean deleteData(String inputName) throws Exception {
		System.out.println("name"+inputName);
		boolean flag=true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAOImpl dao = (UserDAOImpl) context.getBean("UserDAO");
		dao.delete(dao.findByName(inputName).get(0));
		
		return flag;
	}
}