package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class persistApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;

		try {
			session = hibernateUtil.getSession();
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				Student student = new Student();
				student.setSid(2);
				student.setsName("sacjjhn");

				student.setsAddres("mubiai");

				// this save method is used for inserting in jdbc
				// this method comes from Session class of Hibernate
				// return type of this method is serializable(this method will return primary
				// key value of the inserted row)
				// wrapper classes are also serializable

				// id=(Integer)session.save(student);

				// this persist method also do insert operation with return type as void
				// this method comes from jpa specification so this method will always work no
				// matter
				// what orm tool you use

				session.persist(student);
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object saved to the databse .");

			} else {
				trnxn.rollback();
				System.out.println("object not saved to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
