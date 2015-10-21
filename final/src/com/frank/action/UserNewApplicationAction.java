package com.frank.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.ApplicantDAOImpl;
import com.frank.model.Applicant;
import com.frank.model.Resume;
import com.frank.model.ResumeDAO;
import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserNewApplicationAction extends ActionSupport {
	private String publisher;
	private String projectName;
	


	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Action(value = "userNewApplication", results = {
			@Result(name = ERROR, location = "error.jsp"),
			@Result(name = SUCCESS, location = "/user/applicationSuccess.jsp"),
	})
		
	public String execute() {
		System.out.println(projectName+"   "+publisher);
			if(setData(projectName,publisher)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return ERROR;}
	}
	
	public boolean setData(String projectName,String publisher){
				boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String userName=(String) session.getAttribute("name");
		ApplicantDAOImpl dao = (ApplicantDAOImpl) context.getBean("ApplicantDAO");
		
		Applicant a=new Applicant();
		a.setPublisher(publisher);
		a.setUserName(userName);
		a.setProjectName(projectName);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String t = dateFormat.format( now ); 
		a.setTime(t);
		
		if(dao.save(a)){
			flag=true;
		}
		//System.out.println("try");
		
		return flag;
	}
	
}
