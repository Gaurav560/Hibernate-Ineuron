package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy1;
import in.ineuron.util.hibernateUtil;

public class ClientApp1 {
	public static void main(String[] args) {
		Session session = null;
	Boolean flag=false;
	Transaction trnxn=null;
int id=1;
	
			session = hibernateUtil.getSession();
			try {
			 trnxn=session.beginTransaction();
				InsurancePolicy1 ipp=session.get(InsurancePolicy1.class, id);
				System.out.println(ipp);
Thread.sleep(30000);// main thread will sleep for 30 sec
ipp.setTenure(70);
flag=true;
	}

	catch(

	HibernateException he)
	{
		he.printStackTrace();
	}catch(
	Exception e)
	{
		e.printStackTrace();
	}finally
	{
		if (flag) {
			trnxn.commit();
			System.out.println("object updated with id::"+id);
		}else {
			trnxn.rollback();
			System.out.println("object not updated ::"+id);
		}

		hibernateUtil.closeSession(session);
		hibernateUtil.closeSessionFactory();
	}

}

}
