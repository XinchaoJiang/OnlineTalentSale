package com.frank.action;

import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.UserDAOImpl;
import com.frank.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author steve frank
 * 
 */
public class LoginAction extends ActionSupport {
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
	@Action(value = "userLogin", results = {
			@Result(name = INPUT, location = "/index.jsp"),
			@Result(name = SUCCESS, location = "/user/toUserHome.jsp") })		
	public String execute() {
		System.out.println(name+"  !!!!  "+password);
	//	;
		//if (name.equals("steve") && password.equals("123"))
			if(getData(name,password)){
				System.out.println("aaaaa");
			return SUCCESS;}

		else{
			return INPUT;}
	}

	private boolean getData(String inputName,String inputPassword) {
		System.out.println("name: "+inputName+"   password"+inputPassword);
		boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAOImpl dao = (UserDAOImpl) context.getBean("UserDAO");
		List<User> list = dao.findAll();
		int n = list.size();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		for (int i = 0; i < n; i++) {
			User c = list.get(i);
			String name = c.getName();
			String password=c.getPassword();
			//System.out.println(name);
			if(name.equals(inputName)&&password.equals(inputPassword)){
				flag=true;

				System.out.println("successful: "+name);
				session.setAttribute("name", name);
				session.setAttribute("role", "user");
				session.setAttribute("password",inputPassword);
				session.setAttribute("phone", c.getPhone());
			session.setAttribute("email", c.getEmail());
				
				break;
			}
		}
		
		if(!flag){
			session.setAttribute("login", "fail");
		}
		
		return flag;
	}
	

	
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
}