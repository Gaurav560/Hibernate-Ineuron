package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp6 {

	public static void main(String[] args)

	{

//in the previous code we were making object of list array and then after making object checking in the list array that object is null or not .
		// as we know object creation is a heavy and costly task,so we try to avoid creating list 
		// object if no object is inside the list array array object .there is a method called
		// uniqueResult in query class.
		Session session = null;
		Integer id = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold HQL
			@SuppressWarnings("unchecked")
			Query<products> query = session.createQuery(" FROM in.ineuron.model.products WHERE pid=:id");

			// Setting values to the parameter
			id = 1;
			query.setParameter("id", id);

			// execute the query
			products prod = query.uniqueResult();

		if (prod!=null) {
			System.out.println(prod);
			
		}else {
			System.out.println("object not found in the database");
		}
			
		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
