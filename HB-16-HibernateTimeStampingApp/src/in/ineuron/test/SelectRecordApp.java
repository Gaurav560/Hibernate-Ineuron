package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Long id = 1L;
		Boolean flagBoolean = false;
		Transaction transaction = null;
		BankAccount bankAccount = null;

		try {
			session = hibernateUtil.getSession();
			bankAccount = session.get(BankAccount.class, id);
			System.out.println("before modification::" + bankAccount);

			if (bankAccount != null)
			{

				transaction = session.beginTransaction();
				bankAccount.setBalance(bankAccount.getBalance() + 100000L);
				System.out.println("After modification::" + bankAccount);
				flagBoolean = true;
			}
			
			
			else
			{
				System.out.println("record not available for the given id." + id);
				System.exit(0);
			}

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flagBoolean) {
				transaction.commit();
				System.out.println("object updated");
				System.out.println("Account opening date::" + bankAccount.getOpeningDate());
				System.out.println("account last updated ::" + bankAccount.getLastUpdated());
			} else {
				transaction.rollback();
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
