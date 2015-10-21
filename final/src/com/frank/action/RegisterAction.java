package com.frank.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.UserDAOImpl;
import com.frank.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
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
	
	@Action(value = "register", results = {
			@Result(name = INPUT, location = "/user/registerFail.jsp"),
			@Result(name = SUCCESS, location = "/user/registerDone.jsp") })
		
	public String execute() {

			if(setData(name,password)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return INPUT;}
	}
	
	public boolean setData(String inputName,String inputPassword ){
				boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAOImpl dao = (UserDAOImpl) context.getBean("UserDAO");
		if(existingName(inputName,dao.findAll())){
			flag=false;
		}else{
			
					User s=new User();
		s.setName(inputName);
		s.setRoleId(1);
		s.setPassword(inputPassword);

		dao.save(s);
			flag=true;
		//}
		}
		

		//System.out.println("try");
		
		return flag;
	}
	private boolean existingName(String name,List<User> list){
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			if(name.equalsIgnoreCase(list.get(i).getName())){
				flag=true;
				break;
			}
		}
		
		
		return flag;
	}
	
}
