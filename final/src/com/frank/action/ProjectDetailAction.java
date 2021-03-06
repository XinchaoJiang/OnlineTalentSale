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

/**
 * @author steve frank
 * 
 */
public class ProjectDetailAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Action(value = "projectDetail", results = {
			@Result(name = ERROR, location = "/error.jsp"),
			@Result(name = SUCCESS, location = "/company/projectDetail.jsp") })
		
	public String execute() {
	//	;
		//if (name.equals("steve") && password.equals("123"))
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String role=(String) session.getAttribute("role");
		System.out.println("role: "+role);
			if(getData()&&role.equals("company")){
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
		ProjectDAOImpl dao = (ProjectDAOImpl) context.getBean("ProjectDAO");
		System.out.println("find"+name);
		List<Project> list = dao.findByName(name);
		System.out.println("find done");

		int n = list.size();
		if(n!=1){
			System.out.println("error!");
			return false;}
		
		for(int i=0;i<n;i++){
			System.out.println(""+list.get(i).getName());
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		
		try{
		   request.setAttribute("project", list);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}