package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.frank.impl.UserDAOImpl;
import com.frank.model.User;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAOImpl dao = (UserDAOImpl) context.getBean("StudentDAO");
		List<User> list = dao.findAll();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			User c = list.get(i);
			String name = c.getName();
			System.out.println(name);
		}
	}
}