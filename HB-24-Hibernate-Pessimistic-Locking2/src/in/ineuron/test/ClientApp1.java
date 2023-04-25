package in.ineuron.test;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
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
				InsurancePolicy1 ipp=session.get(InsurancePolicy1.class, id,LockMode.UPGRADE_NOWAIT);
				System.out.println(ipp);
Thread.sleep(30000);

ipp.setTenure(90);
InsurancePolicy1 ipp1=session.get(InsurancePolicy1.class, id,LockMode.UPGRADE_NOWAIT);
System.out.println(ipp1);
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
