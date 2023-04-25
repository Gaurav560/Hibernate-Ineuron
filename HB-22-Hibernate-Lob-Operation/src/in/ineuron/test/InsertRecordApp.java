package in.ineuron.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.JobSeeker;
import in.ineuron.util.hibernateUtil;



public class InsertRecordApp {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Integer id = null;
		byte[] photo=null;
		char[] resume=null;
		File f=null;
		
		
		//this logic for copying the image data to byte[]
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Gaurav\\Downloads\\h24.jpg");
			 photo=new byte[fis.available()];
			fis.read(photo);
			
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
		//this logic for copying the character data to char array 
		try {
		 f=new File("E:\\resume.txt");
		 try(FileReader fr=new FileReader(f)) {
			 resume=new char[(int)f.length()];
				fr.read(resume);
		} 
			
			
		} catch (IOException ei) {
		ei.printStackTrace();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {
JobSeeker jobSeeker=new JobSeeker();
jobSeeker.setJsName("Gaurav");
jobSeeker.setJsAddr("Gaya");
jobSeeker.setPhoto(photo);
jobSeeker.setResume(resume);

			id=(Integer)session.save(jobSeeker);
			flag=true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				trnxn.commit();
				System.out.println("object inserted to the databse ." + id);

			} else {
				trnxn.rollback();
				System.out.println("object not inserted to database.....");
			}

			hibernateUtil.closeSession(session);
			hibernateUtil.closeSessionFactory();
		}

	}

}
