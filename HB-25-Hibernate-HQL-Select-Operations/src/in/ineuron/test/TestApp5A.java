package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp5A {

	public static void main(String[] args)

	{

//for select(one column only->no object type array is required as it does not give objects .we know the data type of what that column will yield .We will write that column type in our LIst) operation in HIBERNATE no transaction is required
		Session session = null;
		Integer id = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold HQL
			@SuppressWarnings("unchecked")
			Query<products> query = session.createQuery(" FROM in.ineuron.model.products WHERE pid=:id");
			;

			// Setting values to the parameter
			id = 44;
			query.setParameter("id", id);

			// execute the query
			// List<products ka matlab hai list array mein products class ka objects stored
			// hai.and we can acces them through indexing >
			List<products> li = query.list();
			System.out.println(li.size());
			System.out.println("PRICE");

			// process the List
			if (!li.isEmpty()) {
				// taking an object form list and storing it in prod named object of products
				// class.
				products prod = li.get(0);
				System.out.println(prod);

			} else {
				System.out.println("record not available for the given id.");
			}

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
