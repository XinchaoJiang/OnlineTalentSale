package com.frank.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.CompanyDAOImpl;
import com.frank.model.Company;
import com.opensymphony.xwork2.ActionSupport;


public class AdminAddCompanyAction extends ActionSupport {
	private String name;
	private String password;
	private String description;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "adminAddCompany", results = {
			@Result(name = INPUT, location = "/admin/addCompanies.jsp"),
			@Result(name = SUCCESS, location = "/admin/addCompanies.jsp"), 
			@Result(name=ERROR, location="/error.jsp")})
		
	public String execute() {
		if(name==null){
			return INPUT;}else{
			}
				try {
					saveData(name,password, description);
						System.out.println("aaaaa");
					return SUCCESS;}catch(Exception e)

					{
						return ERROR;
						}
				} 
	

	private void getData(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		CompanyDAOImpl dao = (CompanyDAOImpl) context.getBean("CompanyDAO");
		System.out.println("find");
		List<Company> list = dao.findAll();
		System.out.println("find done");
		int n = list.size();
		System.out.println(n);
		if(n==0){
			System.out.println("no object return!");}
		   request.setAttribute("adminCompanies", list);
		
	}
	
	private  void saveData(String inputName,String password,String description) throws Exception {
		System.out.println("name"+inputName);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CompanyDAOImpl dao = (CompanyDAOImpl) context.getBean("CompanyDAO");
		dao.save(new Company(inputName,2,password,description));
			}
}