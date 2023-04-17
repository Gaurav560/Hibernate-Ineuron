package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

//load the record first to check whether the record exist in table or not then update it.
public class UpdateRecord3 {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;

		try {
			session = hibernateUtil.getSession();
			Student student = session.get(Student.class, 2);
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				if (student != null) {
					System.out.println(student);
					student.setsName("MahiRatttttt");

					flag = true;
				}

				else {
					System.out.println("Record not found for updation..");
				}

		

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object updated to the databse .");

			} else {
				trnxn.rollback();
				System.out.println("object not updated to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
