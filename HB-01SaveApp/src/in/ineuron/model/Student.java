package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STDTAB")
public class Student {
	
	@Id
	@Column(name = "stdId")
	private Integer sid;
	
	@Column(name = "stdName",length = 20)
	private String sName;
	@Column(name = "stdAddr",length = 20)
	private String sAddres;
	@Column(name = "stdAge")
	private Integer sAge;

	public Student() {
		System.out.println("zero argument constructors are used by Hibernate Internally.");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddres() {
		return sAddres;
	}

	public void setsAddres(String sAddres) {
		this.sAddres = sAddres;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sAddres=" + sAddres + ", sAge=" + sAge + "]";
	}
}
