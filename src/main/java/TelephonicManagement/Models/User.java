 package TelephonicManagement.Models;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;


@Entity
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Size(min = 5,message="Name size of atleast  5 Character")
	private String name;
	
	@Column(unique=true)
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 5 ,message = "Password sizeeeeeeeee of atleast  5 Character")
	private String password;
	
	public int getId() {
		return id;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")//,orphanRemoval=true) use of cascade:-automatic saving of contact when user saved
	private List<Contacts> contacts = new ArrayList<>();  //one user have multiple contacts
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Role> Role = new HashSet<>();
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Contacts> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}
	public Set<Role> getRole() {
		return Role;
	}
	public void setRole(Set<Role> role) {
		Role = role;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			List<SimpleGrantedAuthority>authorities=this.Role.stream()
					.map((Role)-> new SimpleGrantedAuthority(Role.getRolename())).collect(Collectors.toList());
			
		return authorities;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	


}
