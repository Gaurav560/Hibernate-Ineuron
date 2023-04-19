package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.hibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		Long id=null;
		Boolean flaBoolean=false;
		
		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
			InsurancePolicy policy=new InsurancePolicy();
			policy.setCompany("Aestrick");
			policy.setPolicyName("JeevanBima");
			policy.setTenure(12);
			policy.setPolicyType("Yearly");
			 id = (Long)session.save(policy);
			 flaBoolean=true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flaBoolean) {
				trnxn.commit();
				System.out.println("record successfully inserted to the database with id ::"+id);
				
			}else {
				trnxn.rollback();
				System.out.println("record not inserted in the databse");
			}
			

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
