package org.dxc.AssociationMapping;

import java.util.ArrayList;

import org.dxc.entity.Answer;
import org.dxc.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {	
    	SessionFactory factory;
    	try {
    		factory = new Configuration().configure("resource/hibernate.cfg.xml").buildSessionFactory();
    		
    	} catch (Throwable ex) {
    		System.out.println("Failed to create" + ex);
    		throw new ExceptionInInitializerError(ex);
    	}

    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Answer ans1 = new Answer();
    	ans1.setAnswerName("Java is a programming language");
    	ans1.setPostedBy("Joey");
    	
    	Answer ans2 = new Answer();
    	ans2.setAnswerName("Java is platform");
    	ans2.setPostedBy("Brian");
    	
    	Answer ans3 = new Answer();
    	ans3.setAnswerName("Servlet is Interface");
    	ans3.setPostedBy("Edmund");
    	
    	Answer ans4 = new Answer();
    	ans4.setAnswerName("Servlet is API");
    	ans4.setPostedBy("Damien");
    	
    	ArrayList<Answer> answerList1 = new ArrayList<Answer>();
    	ArrayList<Answer> answerList2 = new ArrayList<Answer>();
    	
    	answerList1.add(ans1);
    	answerList1.add(ans2);
    	answerList2.add(ans3);
    	answerList2.add(ans4);
    	
    	Question question1 = new Question();
    	question1.setQuestionName("What is java");
    	question1.setAnswers(answerList1);
    	
    	Question question2 = new Question();
    	question2.setQuestionName("What is servlet");
    	question2.setAnswers(answerList2);
    	
    	session.persist(question1);
    	session.persist(question2);
    	
    	tx.commit();
    	session.close();
    	System.out.println("Success");
    }
}
