package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.mysql2hibernateUtil;
import in.ineuron.util.mysqlhibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String transferProductById(Integer id) {

		// 1 se 2 mein copy kar rahe hain
		Session mysqlsession = mysqlhibernateUtil.getSession();
		Session mysql2session = mysql2hibernateUtil.getSession();
		Integer idInteger = 0;
		Boolean flagBoolean = false;
		Transaction mysql2Transaction = null;
		
		
		Product product = mysqlsession.get(Product.class, id);
		
		if (product == null) {
			return "product not availablefor copying";

		} 
		
		else 
		
		{
			try 
			
			{
				mysql2Transaction = mysql2session.beginTransaction();
				if (mysql2Transaction != null) 
				
				{
					idInteger = (Integer) mysql2session.save(product);
					flagBoolean = true;
				}
				
				
			}
			
			
			catch (Exception e) 
			
			{
				e.printStackTrace();

			}finally {
				if (flagBoolean==true) {
				mysql2Transaction.commit();
			return "data copied from mysql to mysql2"+idInteger;
					
				}else {
					mysql2Transaction.rollback();
					return "data not copied from mysql to mysql2"+idInteger;
				}
			}

			
		}
	
	}

}
