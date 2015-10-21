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

import com.frank.impl.ProjectDAOImpl;
import com.frank.model.Project;
import com.frank.model.User;
import com.frank.model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class NewProjectAction extends ActionSupport {
	private String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Action(value = "newProject", results = {
			@Result(name = ERROR, location = "error.jsp"),
			@Result(name = SUCCESS, location = "/company/toShowProjects.jsp"),
			@Result(name = INPUT, location = "/company/newProject.jsp"),
	})
		
	public String execute() {
		
		if(action.equals("go")){
			return INPUT;
	}
		if(setData(content)){
			return SUCCESS;}

		else{
			return ERROR;}
	}
	
	public boolean setData(String content){
		System.out.println("New Project Action Set Data");

				boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String userName=(String) session.getAttribute("name");
		ProjectDAOImpl dao = (ProjectDAOImpl) context.getBean("ProjectDAO");
		
		Project r=new Project();
		r.setDescription(content);
		r.setPublisher(userName);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String t = dateFormat.format( now ); 
		r.setTime(t);
		r.setName(name);
		if(dao.save(r)){
			flag=true;
		}
		//System.out.println("try");
		
		return flag;
	}
	
}
