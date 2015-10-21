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


public class AdminDeleteCompanyAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "adminDeleteCompany", results = {
			@Result(name = INPUT, location = "/admin/deleteCompanies.jsp"),
			@Result(name = SUCCESS, location = "/admin/deleteCompanies.jsp"), 
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
	
	private boolean deleteData(String inputName) throws Exception {
		System.out.println("name"+inputName);
		boolean flag=true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CompanyDAOImpl dao = (CompanyDAOImpl) context.getBean("CompanyDAO");
		dao.delete(dao.findByName(inputName).get(0));
		
		return flag;
	}
}