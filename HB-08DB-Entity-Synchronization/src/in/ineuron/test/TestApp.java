package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;

	
		int id = 1;

		try {
			session = hibernateUtil.getSession();	
			Student student = session.get(Student.class, id);
	System.out.println("Before updation in the table:"+student);
if (student!=null) {
	System.in.read();//go to db and make the changes
	session.refresh(student);
	System.out.println("after updation in the table :"+student);
}
else {
	System.out.println("Record available for the given id::"+id);
	
}


	
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	
			

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}}


