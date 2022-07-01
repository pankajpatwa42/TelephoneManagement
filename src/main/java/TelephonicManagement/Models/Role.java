package TelephonicManagement.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Role {
	
	
//	@JsonIgnore
//	@OneToOne
//	private User user;
	
	@Id
	private int roleid;
	
	@Column(nullable = false)
	private String rolename;
	

	public Role() {}
	public Role(int roleid){ 
		this.roleid = roleid;
		
	}
	
	public Role(String rolename)
	{
		this.rolename = rolename;
	}

	
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
