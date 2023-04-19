package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.BankAccount;
import in.ineuron.util.hibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Long id = null;
		BankAccount bAccount = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
				bAccount = new BankAccount();
				bAccount.setBalance(4533353.544);
				bAccount.setHolderName("Gaurav");
				bAccount.setType("Savings");
				id = (Long) session.save(bAccount);
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
				System.out.println(bAccount);

			} else {
				trnxn.rollback();
				System.out.println("object not inserted to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
