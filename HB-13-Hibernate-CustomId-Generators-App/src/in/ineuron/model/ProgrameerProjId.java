package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable // means the object data of this class will be used as primary key in future
public class ProgrameerProjId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//implementing serializable just to make sure it is proper bean 
	private Integer pid;
	private Integer projId;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	@Override
	public String toString() {
		return "ProgrameerProjId [pid=" + pid + ", projId=" + projId + "]";
	}

}
