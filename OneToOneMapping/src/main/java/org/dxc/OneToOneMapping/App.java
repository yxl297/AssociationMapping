package org.dxc.OneToOneMapping;

import org.dxc.Entity.Address;
import org.dxc.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Failed to create Session");
			throw new ExceptionInInitializerError(e);
		}
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Edmund");
		e1.setEmail("edmund@gmail.com");

		Employee e2 = new Employee();
		e2.setName("Brian");
		e2.setEmail("brian@gmail.com");

		Address address1 = new Address();
		address1.setAddressLine1("1 Depot Close");
		address1.setCity("Singapore");
		address1.setState("Singapore");
		address1.setCountry("Singapore");
		address1.setPincode(109841);
		
		Address address2 = new Address();
		address2.setAddressLine1("10 Bayfront Ave");
		address2.setCity("Singapore");
		address2.setState("Singapore");
		address2.setCountry("Singapore");
		address2.setPincode(189560);

		e1.setAddress(address1);
		address1.setEmployee(e1);
		
		e2.setAddress(address2);
		address2.setEmployee(e2);

		session.persist(e1);
		session.persist(e2);

		tx.commit();

		session.close();
		System.out.println("success");
	}
}