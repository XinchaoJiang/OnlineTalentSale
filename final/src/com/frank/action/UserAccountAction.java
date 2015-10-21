package com.frank.action;

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

public class UserAccountAction extends ActionSupport {
	private String name;
	private String password;
	private String phone;
	private String email;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	
	@Action(value = "userAccount", results = {
			@Result(name = INPUT, location = "/user/userAccount.jsp"),
			@Result(name = SUCCESS, location = "/user/userAccount.jsp") })
		
	public String execute() {
		//System.out.println(name+password+phone+email);

		if(setData(name,password,phone,email)){
			return SUCCESS;
		}else{
		
		
		return INPUT;}
			//if(setData(name,password)){
		//		System.out.println("aaaaa");
			//return SUCCESS;}

	//	else{
		//	return INPUT;}
	}
	
	public boolean setData(String inputName,String inputPassword,String inputPhone,String inputEmail ){
				boolean flag=true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAOImpl dao = (UserDAOImpl) context.getBean("UserDAO");
try{
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session = request.getSession(); 
	
	session.setAttribute("name", inputName);
	session.setAttribute("role", "user");
	session.setAttribute("password",inputPassword);
	session.setAttribute("phone", inputPhone);
session.setAttribute("email", inputEmail);
	
	
		User s=new User();
		dao.delete(dao.findByName(inputName).get(0));
		
		s.setName(inputName);
		s.setRoleId(1);
		s.setPassword(inputPassword);
		s.setPhone(inputPhone);
		s.setEmail(inputEmail);
		dao.save(s);
}catch(Exception e){
	e.printStackTrace();
	flag=false;
}

		return flag;
	}

	
}
