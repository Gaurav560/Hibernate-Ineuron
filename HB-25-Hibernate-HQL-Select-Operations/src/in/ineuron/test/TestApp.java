package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp {

	public static void main(String[] args)

	{

//for select(all objects) operation in hibernate no transaction is required
		Session session = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold hql
			Query<products> query = session.createQuery("FROM in.ineuron.model.products");// works same as selct * from products
			
			//execute the query
			List<products> li = query.list();
			
			//process the List Object 
			li.forEach(System.out::println);
			

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
