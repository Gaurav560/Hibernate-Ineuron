package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp2 {

	public static void main(String[] args)

	{

//for select some objects operation in hibernate no transaction is required
		Session session = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold hql
			@SuppressWarnings("unchecked")
			Query<products> query = session.createQuery("FROM in.ineuron.model.products WHERE pname IN(:prod1,:prod2)");

			
			//SQL query for this HQL query will be ->select * from products where pname in("savlon","denver");
			
			//Setting values to the parameter
			query.setParameter("prod1", "savlon");
			query.setParameter("prod2", "denver");
			
			// execute the query
			List<products> li = query.list();

			// process the List Object
			li.forEach(System.out::println);

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
