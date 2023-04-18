package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId//this object data is used as primary key 	// ProgrameerProjId --this is type of below id 
	private ProgrameerProjId id;
	private String projName;
	private Integer deptN0;
	private String pname;
	
	
	
	
	
	//getters and setters
	
	

	public ProgrameerProjId getId() {
		return id;
	}

	public void setId(ProgrameerProjId id) {
		this.id = id;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}


	public Integer getDeptN0() {
		return deptN0;
	}

	public void setDeptN0(Integer deptN0) {
		this.deptN0 = deptN0;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	
	//to String method overridden 	
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", projName=" + projName + ", deptN0=" + deptN0 + ", pname=" + pname
				+ "]";
	}


}
