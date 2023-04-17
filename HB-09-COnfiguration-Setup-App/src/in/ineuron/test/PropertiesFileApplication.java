package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class PropertiesFileApplication {

	public static void main(String[] args) {
		Session session = null;
		SessionFactory sessionFactory = null;

		int id = 1;

		try {

			// empty configuration object got created
			Configuration configuration = new Configuration();// by default HIBERNATE will search for
																// hibernate.properties file

			// providing information about mapping file
			configuration.addAnnotatedClass(Student.class);

			// from configuration object ,trying to build a session factory object
			sessionFactory = configuration.buildSessionFactory();

			// from sessionFactory Objectt ,trying to open a neew session
			session = sessionFactory.openSession();

			Student student = session.get(Student.class, id);
			System.out.println("Before updation in the table:" + student);
			if (student != null) {
				System.in.read();// go to db and make the changes
				session.refresh(student);
				System.out.println("after updation in the table :" + student);
			} else {
				System.out.println("Record available for the given id::" + id);

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
