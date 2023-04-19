package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;

		Long id1 = 1L;

		try {
			session = hibernateUtil.getSession();

			// gets from database and puts in L1-Cache
			InsurancePolicy policy1 = session.get(InsurancePolicy.class, id1);
			System.out.println("1:" + policy1);
			System.out.println("-----------------------------------");

			// gets directly from L1-Cache as earlier this data was stored in L1-cache while
			// recieving the data from db
//no query will be generated to fetch the data from database 
			InsurancePolicy policy2 = session.get(InsurancePolicy.class, id1);
			System.out.println("2:" + policy2);
			System.out.println("-----------------------------------");

			// session.evict will remove the policy object from L1-Cache
			// now it will fetch from db
			session.evict(policy1);

			// after eviction of policy object from L1-Cache ,now it will search in L2_cache
			// (which we have configured through ECCache Software )

			InsurancePolicy policy3 = session.get(InsurancePolicy.class, id1);
			System.out.println("3:" + policy3);
			System.out.println("-----------------------------------");

			session.clear();// removes all objects from L1-Cache
			Thread.sleep(20000);// it will sleep the thread and halt the operation for 20 second
			// and thus it will cross the 10 second timeToIdleSeconds after which cached
			// objected stored in
			// L-2 cache will be destroyed.
			
			
			
			//now cached object in L2-Cache is destroyed so ,a new query will be generated and data will be fetched from database 
			InsurancePolicy policy4 = session.get(InsurancePolicy.class, id1);
			System.out.println("4:" + policy4);
			System.out.println("-----------------------------------");
			
		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
