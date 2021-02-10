package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.utils.Question;
import com.test.utils.User;
import com.test.utils.onlineExam;

@RestController
public class examController {
		
	
		// Registration Section
	
		@PostMapping("/addstudent")
		public User addStudent(@RequestBody User user) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(User.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
			session.save(user);
		
			tx.commit();
			session.close();
			fact.close();
			return user;
		}
		
		
		//teacher Section
		
		@PostMapping("/addteacher")
		public User addTeacher(@RequestBody User user) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(User.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
			
			if(user.getType().equals("TEACHER"))
				session.save(user);
			else 
				System.out.println( "You are not Teacher");
			tx.commit();
			session.close();
			fact.close();
			return user;
		}
		
		@GetMapping("/getStudent")
		public List<User> getAllStudent() {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Question.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
			
			Query q= session.createQuery("from User");
			List<User> l1 = q.list();
			System.out.println(l1);
			
			
			tx.commit();
			session.close();
			fact.close();
			return l1;
		}
		
		@GetMapping("/getStudent/{id}")
		public User getParticularStudent(@PathVariable("id") int id) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Question.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
			
			Query q= session.createQuery("from User");
			List<User> l1 = q.list();
			System.out.println(l1);
			
			User temp= null;
			for(User e :l1)
				if(e.getUserId()== id)
					temp=e;
			
			tx.commit();
			session.close();
			fact.close();
			return temp;
		}
		
		
		
		//Question Section
		@PostMapping("/queAdd")
		public Question addQuestion(@RequestBody Question que) {
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Question.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
			session.save(que);
		
			tx.commit();
			session.close();
			fact.close();
			return que;
		}
		
		@PutMapping("/queUpdate")
		public Question updateQuestion(@RequestBody Question que) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Question.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
			session.update(que);;
		
			tx.commit();
			session.close();
			fact.close();
			return que;
		}
		
		@DeleteMapping("/queDelete")
		public Question deleteQuestion(@RequestBody Question que) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Question.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
			session.delete(que);
		
			tx.commit();
			session.close();
			fact.close();
			return que;
		}
		
		//Question Section
		@PostMapping("/examAdd")
		public onlineExam addExam(@RequestBody onlineExam exam) {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(onlineExam.class);
			SessionFactory fact = cfg.configure().buildSessionFactory();
			Session session = fact.openSession();
			Transaction tx = session.beginTransaction();
		
			session.save(exam);
		
			tx.commit();
			session.close();
			fact.close();
			return exam;
		}
}

