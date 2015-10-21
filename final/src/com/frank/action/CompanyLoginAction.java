package com.frank.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.CompanyDAOImpl;
import com.frank.model.Company;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class CompanyLoginAction extends ActionSupport {
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
	@Action(value = "companyLogin", results = {
			@Result(name = INPUT, location = "/company/companyLogin.jsp"),
			@Result(name = SUCCESS, location = "/company/companyIndex.jsp") })	
	public String execute() {
		System.out.println("company login");
		System.out.println(name+"  "+password);
	//	;
		//if (name.equals("steve") && password.equals("123"))
			if(getData(name,password)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return INPUT;}
	}

	private boolean getData(String inputName,String inputPassword) {
		boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CompanyDAOImpl dao = (CompanyDAOImpl) context.getBean("CompanyDAO");
		List<Company> list = dao.findAll();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			Company c = list.get(i);
			String name = c.getName();
			String password=c.getPassword();
			//System.out.println(name);
			if(name.equals(inputName)&&password.equals(inputPassword)){				
				flag=true;
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session = request.getSession(); 
				System.out.println(name);
				session.setAttribute("name", name);
				session.setAttribute("role", "company");
				break;
			}
		}
		return flag;
	}
}