package in.ineuron.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Annotations

@Entity
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyNo;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	
	
	//getters and setters
	public Long getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(Long policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
	
	//toString method
	
	@Override
	public String toString() {
		return "InsurancePolicy [policyNo=" + policyNo + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
	
	
}
