package in.ineuron.idgenerator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		int num = new Random().nextInt(1000);
		String prefixString = "Ineuron-";
		String prefix2ixString = "HB-";
		return prefixString + dateString +"-"+ prefix2ixString + num;
	}

}
