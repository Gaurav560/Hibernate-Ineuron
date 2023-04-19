package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Student;
import in.ineuron.util.hibernateUtil;

public class MergeRecordApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Student student2=null;
		try {

			Student student = new Student();
			student.setSid(5);
			student.setsName("ashoka");
			student.setsAge(23);
			student.setsAddres("kalinga");
			
			session = hibernateUtil.getSession();
			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) { 
				
				//session.merge method -pehle select operation laga ke check karega through id
			//agar same id ka object mila db mein aur saari values bhi same hain to 
				//to no updation .agar naya data hai with new id then insertion else with with old 
				//id new data,then updation will be done.This is Version 1 of merge .Similar to saveOrUpdate method
				//so better go for update method if you want to perform this type of work .
			student2=(Student)session.merge(student);
				flag = true;

			}

		}catch(

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
			System.out.println("object updated to the databse .");

		} else {
			trnxn.rollback();
			System.out.println("object not updated to database.....");
		}

		hibernateUtil.closeSession(session);
		hibernateUtil.closeSessionFactory();
	}

}

}
