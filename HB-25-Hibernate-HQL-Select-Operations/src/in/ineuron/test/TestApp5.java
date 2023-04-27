package in.ineuron.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp5 {

	public static void main(String[] args)

	{

//for select(one column only->no object type array is required as it does not give objects .we know the data type of what that column will yield .We will write that column type in our LIst) operation in HIBERNATE no transaction is required
		Session session = null;
		Integer id=null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold HQL
			@SuppressWarnings("unchecked")
			Query<products> query = session
					.createQuery(" FROM in.ineuron.model.products WHERE pid=:id");

		
			// Setting values to the parameter
			id=1;
			query.setParameter("id",id);
		

			// execute the query
			List<products> li = query.list();

			System.out.println("PRICE");
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
