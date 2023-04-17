package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class DeleteRecordApp1 {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;

		try {
			session = hibernateUtil.getSession();
			int id = 66;
			Student student = session.get(Student.class, id);
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				if (student != null) {
					session.delete(student);
					flag = true;
				}
			}

			else {
				System.out.println("record not available for deletetion:" + id);

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
