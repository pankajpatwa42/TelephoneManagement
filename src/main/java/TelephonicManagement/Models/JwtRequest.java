package TelephonicManagement.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class JwtRequest {
	
	@Email @NotNull
	String username;
	@NotNull
	String password;
	
	public JwtRequest() {}
	public JwtRequest(String username, String password) {
	
		this.username = username; 
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
