package com.frank.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.ResumeDAOImpl;
import com.frank.model.Resume;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class UserShowResumeAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "userShowResume", results = {
			@Result(name = ERROR, location = "/show/error.jsp"),
			@Result(name = SUCCESS, location = "/user/showResume.jsp") })
		
	public String execute() {
	//	;
		//if (name.equals("steve") && password.equals("123"))
			if(getData()){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return ERROR;}
	}

	private boolean getData() {
		boolean flag=true;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String userName=(String) session.getAttribute("name");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ResumeDAOImpl dao = (ResumeDAOImpl) context.getBean("ResumeDAO");
		System.out.println("find"+userName);
		
		List<Resume> list = dao.findByUserName(userName);
		System.out.println("find done");

		int n = list.size();
		if(n!=1){return false;}
		
		for(int i=0;i<n;i++){
			System.out.println(""+list.get(i).getContent());
		}
		
		try{
		   request.setAttribute("resumeList", list);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}