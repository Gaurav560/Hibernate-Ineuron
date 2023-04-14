package in.ineuron.test;

import org.hibernate.cfg.Configuration;
import in.ineuron.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestApp {

	public static void main(String[] args) {
//1.	inform jvm to activate hibernate 
		// first we created an configuration object and inside the configuration object
		// i kept the information present in hibernate.cfg.xml file
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// creating a session factory object to hold many other objects required for
		// HIBERNATE
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Using session factory object,get only one session to perform our persistence
		// operations
		Session session = sessionFactory.openSession();// inside session object connection object,L1-Cache,ORM
														// Dialects,Transaction Management
														// are available

		
		//when you perform non-select operations ,transaction management is required
		//begin the transaction  with respect to session 
		
		
		Transaction trnxn=session.beginTransaction();
		// 2. CREATE PERSISTENCE OBJECT

		Student student = new Student();
		student.setSid(11);
		student.setsName("Gaurav");
		student.setsAge(24);
		student.setsAddres("Gaya");

		// 3.perform PERSISTENCE operation using ENTITY/Model/POJO Object
		session.save(student);// when you told save ,every operation reflected in L1-Cache

		//4.Generate the query and send it to database for execution 
		trnxn.commit();
		
		System.out.println("object saved to databse ");
		
		
	}

}
