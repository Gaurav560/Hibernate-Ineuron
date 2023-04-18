package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		MobileCustomer mobileCustomer = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				mobileCustomer = session.get(MobileCustomer.class, 1);
				System.out.println("before  modification(Loading the object) ::" + mobileCustomer);

				transaction = session.beginTransaction();
				mobileCustomer.setCallerTune("rcccccbbbb..");
				session.update(mobileCustomer);
				flag = true;
			}

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object updated to the database...");
				System.out.println("object after modifcation::" + mobileCustomer);
			} else {
				transaction.rollback();
				System.out.println("object not updated to the database .");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
