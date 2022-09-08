package org.dxc.ManyToOneMapping;

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

		e1.setAddress(address1);
		e2.setAddress(address1);

		session.persist(e1);
		session.persist(e2);

		tx.commit();
		session.close();
		System.out.println("success");
	}
}
