package com.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.utils.User;
import com.test.utils.loginForm;

@RestController
public class loginController {
	
	
		@PostMapping(value = "/login")
		public String getInfo(@RequestParam("username")String user, @RequestParam("password")String pass) {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(loginForm.class);
			cfg.addAnnotatedClass(User.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
		//	if(user.equals("admin") && pass.equals("admin"))
		//		System.out.println("you are admin");
			
			
			Query q= session.createQuery("from User");
			List<User> l1 = q.list();
			System.out.println(l1);
			
			User temp= null;
			for(User e :l1)
				if(e.getType().equals(user))
					System.out.println("you are teacher");
				else if(e.getType().equals(user) && e.getType().equals(pass))
					System.out.println("you are admin");
				else 
					session.save(new loginForm(1, user, pass));
			System.out.println("you are Student");
				
					
				
				
			tx.commit();
			session.close();
			fact.close();
			return "User added Successfully";
		}

}
