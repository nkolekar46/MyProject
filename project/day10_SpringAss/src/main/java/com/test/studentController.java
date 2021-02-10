package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.utils.Question;
import com.test.utils.User;


@RestController
public class studentController {

	
	@GetMapping("/getQues")
	public List<Question> getQuesForStudent() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Question.class);
		SessionFactory fact = cfg.configure().buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();

		Query q= session.createQuery("from Question");
		List<Question> l1 = q.list();
		System.out.println(l1);
		
		
		tx.commit();
		session.close();
		fact.close();
		return l1;
	}
	
	@GetMapping("/getparticularQues/{id}")
	public Question getParticularQuestion(@PathVariable("id") int id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Question.class);
		SessionFactory fact = cfg.configure().buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		
		Query q= session.createQuery("from Question");
		List<Question> l1 = q.list();
		System.out.println(l1);
		
		Question temp= null;
		for(Question e :l1)
			if(e.getQuesId()== id)
				temp=e;
		
		tx.commit();
		session.close();
		fact.close();
		return temp;
	}
	
	
	
	
}
