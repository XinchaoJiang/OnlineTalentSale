package com.frank.action;

import java.util.ArrayList;
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
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class UserHome extends ActionSupport {



	@Action(value = "toUserHome", results = {
			@Result(name = ERROR, location = "/show/error.jsp"),
			@Result(name = SUCCESS, location = "/user/userIndex.jsp") })
		
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
		ApplicantDAOImpl dao = (ApplicantDAOImpl) context.getBean("ApplicantDAO");
		System.out.println("find"+userName);
		
		List<Applicant> list = dao.findByUserName(userName);
		System.out.println("find done");
		List<Applicant> l=new ArrayList<Applicant>();
		int n=list.size();
		if(n>=5){
		for(int i=0;i<5;i++){
			l.add(list.get(n-i-1));
		}}else{l.addAll(list);}
		try{
		   request.setAttribute("myApplicationList", l);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}