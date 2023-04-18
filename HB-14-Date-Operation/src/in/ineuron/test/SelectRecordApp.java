package in.ineuron.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;


import in.ineuron.model.PersonInfo;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				int id = 10;
				PersonInfo objInfo = session.get(PersonInfo.class, id);

				if (objInfo != null) {
					System.out.println(objInfo);

				} else {
					System.out.println("Record not available for this id.." + id);
				}

			}

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
