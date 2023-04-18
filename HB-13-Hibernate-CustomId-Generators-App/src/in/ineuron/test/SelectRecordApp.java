package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.ProgrameerProjId;
import in.ineuron.model.ProgrammerProjectInfo;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				ProgrameerProjId projId = new ProgrameerProjId();
				projId.setPid(10);
				projId.setProjId(500);
				ProgrammerProjectInfo objInfo = session.get(ProgrammerProjectInfo.class, projId);
				if (objInfo != null) {
					System.out.println(objInfo);

				} else {
					System.out.println("Record not available for this id.." + projId);
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
