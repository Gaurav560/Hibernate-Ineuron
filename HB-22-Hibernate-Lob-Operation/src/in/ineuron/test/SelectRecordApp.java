package in.ineuron.test;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;

import org.hibernate.Session;


import in.ineuron.model.JobSeeker;
import in.ineuron.util.hibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;
		JobSeeker seeker=null;
int id=1;
		try {
			session = hibernateUtil.getSession();

			if (session != null) {
				seeker=session.get(JobSeeker.class, id);
			
				}
			if (seeker!=null) {
				System.out.println("id is::"+seeker.getJsId());
				System.out.println("Name is ::"+seeker.getJsName());
				System.out.println("address is ::"+seeker.getJsAddr());
				
				//its called try with resources where you don't need to have a catch block with try block 
				try(FileOutputStream fos=new FileOutputStream("./store/h24.jpg");FileWriter fw=new FileWriter("./store/resume.txt"))
				{
					
					fos.write(seeker.getPhoto());
					fw.write(seeker.getResume());
					System.out.println("photo and resume got located to ::./store/*****");
				}
			
			}
				else {
					System.out.println("Record not available for this id.." + id);
				}
			
		

			

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

		hibernateUtil.closeSession(session);
		hibernateUtil.closeSessionFactory();
	}

}

}
