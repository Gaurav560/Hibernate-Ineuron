package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

//this @Entity is used for making table with same name as class name

@Entity
public class MobileCustomer {

	// annotation for making cid as primary key and auto incremented
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	private String cname;
	private Long mobileNumber;
	private String callerTune;

//this annotation also called version is used for  
	@Version
	private Integer versionCount;

	
	
	//Getters and Setters 
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

//to String method-jab hm sout karte hai to internally wo toString method ko  call karta hai.
//hm program mein object ko sout karenge to toString ko call karega ,par hm toString method ko override krdiye hain 
//ab jab bhi hm sout karenge is class ka object to ye overriden toString method call hoga .

	@Override
	public String toString() {
		return "MobileCustomer [cid=" + cid + ", cname=" + cname + ", mobileNumber=" + mobileNumber + ", callerTune="
				+ callerTune + ", versionCount=" + versionCount + "]";
	}

}
