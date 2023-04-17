package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		Session session = null;



//		in select operations in HIBERNATE ,transaction object is not required.
//		in HIBERNATE we use get method for select operations.

		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				int id = 1;
				Student student = session.load(Student.class, id);
				if (student != null) {
					System.out.println("student id is : " + student.getSid());
				

					System.out.println("student age is: " + student.getsAge());
					
					System.in.read();
					System.out.println("student address is: " + student.getsAddres());
					System.out.println("student name is: " + student.getsName());
				}

				else

					System.out.println("Record not found for the given Id ::" + id);

			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

	
			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
