package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class GetApp {

	public static void main(String[] args) {
		Session session = null;

		boolean flag = false;

//		in select operations in HIBERNATE ,transaction object is not required.
//		in HIBERNATE we use get method for select operations.

		try {
			session = hibernateUtil.getSession();
			if (session != null) {
				int id=677;
				Student student = session.get(Student.class, id);
				if (student != null)

					System.out.println(student);
				else
					System.out.println("Record not found for the given Id ::"+id);

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {

			} else {
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
