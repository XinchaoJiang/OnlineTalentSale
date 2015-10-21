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

import com.frank.impl.ResumeDAOImpl;
import com.frank.model.Resume;
import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class NewResumeAction extends ActionSupport {
	private String content;
	private String action;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Action(value = "userNewResume", results = {
			@Result(name = ERROR, location = "error.jsp"),
			@Result(name = SUCCESS, location = "/user/t.jsp"),
			@Result(name = INPUT, location = "/user/modifyResume.jsp"),
	})
		
	public String execute() {
		
		if(action.equals("go")){
			
			if(getData()){
				System.out.println("aaaaa");
			return INPUT;}

		else{
			return ERROR;}
					}
			if(setData(content)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return ERROR;}
	}
	
	public boolean setData(String content){
				boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String userName=(String) session.getAttribute("name");
		ResumeDAOImpl dao = (ResumeDAOImpl) context.getBean("ResumeDAO");
		
		List<Resume> l=dao.findByUserName(userName);
		if(l.size()>0){
			for(int i=0;i<l.size();i++){
		dao.delete(l.get(i));}
		
		}
		Resume r=new Resume();
		r.setContent(content);
		r.setUserName(userName);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String t = dateFormat.format( now ); 
		r.setTime(t);
		
		if(dao.save(r)){
			flag=true;
		}
		//System.out.println("try");
		
		return flag;
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
			System.out.println("!!!"+list.get(i).getContent());
		}
		
		try{
		   request.setAttribute("myResume", list);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
}
