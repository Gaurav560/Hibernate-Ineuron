package in.ineuron.idgenerator;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
String idString="IN-01";
		return idString;
	}

}
