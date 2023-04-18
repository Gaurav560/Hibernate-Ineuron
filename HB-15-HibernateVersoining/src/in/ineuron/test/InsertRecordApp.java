package in.ineuron.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.hibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Integer id = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {

				MobileCustomer mCustomer=new MobileCustomer();
				mCustomer.setCname("Smriti Mandhana");
				mCustomer.setMobileNumber(4452454553L);
				mCustomer.setCallerTune("Rcb Rcb ...");
				
				
				id=(Integer)session.save(mCustomer);
				
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object inserted to the databse ." + id);

			} else {
				trnxn.rollback();
				System.out.println("object not inserted to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
