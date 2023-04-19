package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;

		Long id1 = 1L;
		Long id2 = 2L;
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
			InsurancePolicy policy3 = session.get(InsurancePolicy.class, id1);
			System.out.println("3:" + policy3);
			System.out.println("-----------------------------------");

			// get from L1-Cache
			InsurancePolicy policy4 = session.get(InsurancePolicy.class, id1);
			System.out.println("4:" + policy4);
			System.out.println("-----------------------------------");

//		Note:in cache memory there can not be duplicate objects.only objects with different id can stay there
			// differne policy numbers reference points to same object
			// fetch from db and stores in L1-Cache
			InsurancePolicy policy5 = session.get(InsurancePolicy.class, id2);
			System.out.println("5:" + policy5);
			System.out.println("-----------------------------------");

//gets from L1_cache(now two Objects stored in L1-Cache based on id)
			InsurancePolicy policy6 = session.get(InsurancePolicy.class, id2);
			System.out.println("6:" + policy6);
			System.out.println("-----------------------------------");

			
			//it removes every object present in L1-Cache
			session.clear();
			
			//gets object form db by creating query
			InsurancePolicy policy7 = session.get(InsurancePolicy.class, id2);
			System.out.println("7:" + policy7);
			System.out.println("-----------------------------------");
			
			//gets object  from db by creating query
			InsurancePolicy policy8 = session.get(InsurancePolicy.class, id1);
			System.out.println("8:" + policy8);
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
