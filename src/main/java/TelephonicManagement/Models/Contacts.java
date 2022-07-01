package TelephonicManagement.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contacts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@NotEmpty(message = "Name not be empty")
	private String name;
	@NotEmpty(message = "Work not be empty")
	private String work;
	@Email
	private String email;
	
	@Pattern(regexp = "^\\d{10}$" , message ="Invalid mobile number Entered ")
	private String phone;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
