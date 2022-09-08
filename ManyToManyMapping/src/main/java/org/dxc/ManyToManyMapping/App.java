package org.dxc.ManyToManyMapping;

import java.util.ArrayList;

import org.dxc.Entity.AnswerMTM;
import org.dxc.Entity.QuestionMTM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	private static SessionFactory factory;
    public static void main( String[] args )
    {	
    	try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Failed to create Session Object " + e);
			throw new ExceptionInInitializerError(e);
		}
    	
    	Session session=factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	AnswerMTM ans1 =  new AnswerMTM();
    	ans1.setAnswerName("Java is a programming language");
    	ans1.setPostedBy("Joey");
    	
    	AnswerMTM ans2 = new AnswerMTM();
    	ans2.setAnswerName("Java is a platform");
    	ans2.setPostedBy("Edmund");
    	
    	AnswerMTM ans3 = new AnswerMTM();
    	ans3.setAnswerName("Servlet is an interface");
    	ans3.setPostedBy("Brian");

    	AnswerMTM ans4 = new AnswerMTM();
    	ans4.setAnswerName("Servlet is an API");
    	ans4.setPostedBy("Damien");
    	
    	ArrayList<AnswerMTM> list1 = new ArrayList<AnswerMTM>();
    	list1.add(ans1); list1.add(ans2);
    	
    	ArrayList<AnswerMTM> list2 = new ArrayList<AnswerMTM>();
    	list1.add(ans3); list1.add(ans4);
    	
    	QuestionMTM question1 = new QuestionMTM();
    	question1.setQuestionName("What is java?");
    	question1.setAnswers(list1);

    	QuestionMTM question2 = new QuestionMTM();
    	question2.setQuestionName("What is a Servlet?");
    	question2.setAnswers(list2);

    	session.persist(question1);
    	session.persist(question2);
    	
    	tx.commit();
    	session.close();
    	System.out.println("Success");
    	
    }
    
}
