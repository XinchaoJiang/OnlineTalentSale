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
import com.frank.model.Project;
import com.frank.model.Resume;
import com.frank.model.ResumeDAO;
import com.opensymphony.xwork2.ActionSupport;


public class CompanyShowProjectsAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Action(value = "companyShowProjects", results = {
			@Result(name = ERROR, location = "/show/error.jsp"),
			@Result(name = SUCCESS, location = "/company/showProjects.jsp") })
		
	public String execute() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String role=(String) session.getAttribute("role");
		System.out.println("role: "+role);
			if(getData()){
			return SUCCESS;}

		else{
			return ERROR;}
	}

	private boolean getData() {
		boolean flag=true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String userName=(String) session.getAttribute("name");
		ProjectDAOImpl dao = (ProjectDAOImpl) context.getBean("ProjectDAO");
		System.out.println("find");
		List<Project> list = dao.findByPublisher(userName);
		System.out.println("find done");

		int n = list.size();
		if(n==0){
			System.out.println("no object return!");
			return false;}
		
		for(int i=0;i<n;i++){
			System.out.println(""+list.get(i).getName());
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		
		try{
		   request.setAttribute("projectList", list);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}