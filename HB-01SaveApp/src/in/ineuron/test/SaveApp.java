package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.classmate.AnnotationOverrides.StdBuilder;
import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class SaveApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction trnxn=null;
		boolean flag=false;


 try {
	 session=hibernateUtil.getSession();
	 if (session!=null) 
		 trnxn=session.beginTransaction();
		
	 if (trnxn!=null) {
		 Student student=new Student();
		 student.setSid(14);
		 student.setsName("amar");
		 student.setsAge(34);
		 student.setsAddres("Gaya");
		 
		 
		 session.save(student);
		 flag=true;
		
	}
	
} catch (HibernateException he) {
	he.printStackTrace();
}catch (Exception e) {
e.printStackTrace();
}finally {
	if (flag) {
		trnxn.commit();
		
	}else {
		trnxn.rollback();
		System.out.println("object not saved to database.....");
	}
	
	hibernateUtil.closeSession(session);
	hibernateUtil.closeSessionFactory();
}
 
 
	}
	

}
