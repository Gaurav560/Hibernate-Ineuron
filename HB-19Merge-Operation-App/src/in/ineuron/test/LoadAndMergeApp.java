package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class LoadAndMergeApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Student student = null;
		Student student1 = null;
		Student student2 = null;

		try {

			session = hibernateUtil.getSession();// L1-Cache
			student = session.get(Student.class, 5);
			System.out.println("after loading the data into L1-Cache ::" + student);
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				// transaction started means from entity life cycle ,this entity will be
				// in persistent state
				student1 = new Student();// L1-Cache
				student1.setSid(5);
				student1.setsAge(32);
				student1.setsName("ashoka");
				student1.setsAddres("orisa");
				session.save(student1);// throws HIBENRATE exception as duplicate objects are not permitted
				// inside the L1-Cache .save method generates insert query.First remove auto increment annotation .
				
				student2 = (Student) session.merge(student1);
				System.out.println("after merging::" + student2);
				System.out.println(student.hashCode() + "::" + student1.hashCode() + "::" + student2.hashCode());

				flag = true;

			}

		} catch (

		HibernateException he) {
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
