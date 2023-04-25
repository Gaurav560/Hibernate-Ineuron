package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class InsurancePolicy1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private String ptype;
	private Integer tenure;
	
	@Version
	private Integer count;

	
	
	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}



	public Integer getPid() {
		return pid;
	}



	public void setPid(Integer pid) {
		this.pid = pid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public String getPtype() {
		return ptype;
	}



	public void setPtype(String ptype) {
		this.ptype = ptype;
	}



	public Integer getTenure() {
		return tenure;
	}



	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}



	@Override
	public String toString() {
		return "InsurancePolicy1 [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", tenure=" + tenure
				+ ", count=" + count + "]";
	}
	
	
	
}
