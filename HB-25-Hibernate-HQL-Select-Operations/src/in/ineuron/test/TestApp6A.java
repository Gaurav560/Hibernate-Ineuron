package in.ineuron.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp6A {

	public static void main(String[] args)

	{

//in the previous code we were making object of list array and then after making object checking in the list array that object is null or not .
		// as we know object creation is a heavy and costly task,so we try to avoid
		// creating list
		// object if no object is inside the list array array object .there is a method
		// called
		// uniqueResult in query class.

		// but there is also an error ,that if uniqueResult method gives null(i.e no
		// object is present in the list array,then we have also to deal with null
		// pointer exception )
		// to deal with null pointer exception,from java 8 ,concept of Optional class is
		// given .The use of optional class is to handle the Null pointer exception
		//and we use a method called uniqueResultOptional 
		Session session = null;
		Integer id = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold HQL
			@SuppressWarnings("unchecked")
			Query<products> query = session.createQuery(" FROM in.ineuron.model.products WHERE pid=:id");

			// Setting values to the parameter
			id = 25;
			query.setParameter("id", id);

			// execute the query
			Optional<products> optional=query.uniqueResultOptional();

			
			//please note that i have not written null handling logic here.it is internally handled bu optional class
			if (optional.isPresent()) {
				System.out.println(optional);

			} else {
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
