package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mysql.cj.result.Row;

import in.ineuron.model.products;
import in.ineuron.util.hibernateUtil;

public class TestApp4 {

	public static void main(String[] args)

	{

//for select(some columns and rows only ) operation in hibernate no transaction is required
		Session session = null;
		try

		{
			session = hibernateUtil.getSession();
			// prepare query object to hold hql
			@SuppressWarnings("unchecked")
			Query<Object[]> query = session
					.createQuery("SELECT price,qty,pname FROM in.ineuron.model.products WHERE pname IN(:prod1,:prod2)");

			// SQL query for this HQL query will be ->select price,qty,pname from products where pname
			// in("savlon","denver");

			// Setting values to the parameter
			query.setParameter("prod1", "savlon");
			query.setParameter("prod2", "denver");

			// execute the query
			List<Object[]> li = query.list();

			
			System.out.println("PRICE\tQTY\tPNAME");
			// process the List Object
			li.forEach(row->{
				
				for (Object objects : row) {
					System.out.print(objects+"\t");
				}
				System.out.println();
			});

		}

		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
