package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class PureJavaApp {

	public static void main(String[] args) {
		Session session = null;
		SessionFactory sessionFactory = null;

		int id = 1;

		try {

			// empty configuration object got created
			Configuration configuration = new Configuration();

			// setting the properties for configuration object using pure Java code
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/oct_batch");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "Lumia@540");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.format_sql", "true");

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
