package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.ProgrameerProjId;
import in.ineuron.model.ProgrammerProjectInfo;
import in.ineuron.util.hibernateUtil;

public class InsertRecordApp {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		ProgrameerProjId pkId = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {

				// creating an object of ProgrameerProjId and injecting values in the object
				// variable
				ProgrameerProjId projId = new ProgrameerProjId();
				projId.setPid(100);
				projId.setProjId(501);

				// creating an object ProgrammerProjectInfo class and injecting the values in
				// object variables
				ProgrammerProjectInfo projectInfo = new ProgrammerProjectInfo();
				projectInfo.setDeptN0(55);
				projectInfo.setId(projId);
				projectInfo.setPname("gaurav");
				projectInfo.setProjName("IPL");
				pkId = (ProgrameerProjId) session.save(projectInfo);
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object inserted to the databse ." + pkId);

			} else {
				trnxn.rollback();
				System.out.println("object not inserted to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
