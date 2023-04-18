package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.hibernateUtil;

public class InsertRecordApp {

//in this first we check whether whether the record exist  or not,if the record exist then it will 
	// perform delete
	public static void main(String[] args) {
		Session session = null;
		Transaction trnxn = null;
		boolean flag = false;
		Integer id = null;

		try {
			session = hibernateUtil.getSession();

			if (session != null)
				trnxn = session.beginTransaction();

			if (trnxn != null) {

				PersonInfo pInfo = new PersonInfo();
				pInfo.setPname("Gauri");
				pInfo.setDob(LocalDate.of(1975, 12, 9));
				pInfo.setDom(LocalDateTime.of(2033, 11, 3, 8, 4));
				pInfo.setDoj(LocalTime.of(9, 15));
				;
				id = (Integer) session.save(pInfo);

				flag = true;

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
