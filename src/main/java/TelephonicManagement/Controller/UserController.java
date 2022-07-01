package TelephonicManagement.Controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TelephonicManagement.Models.User;
import TelephonicManagement.Services.UserService;

@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserController {

	@Autowired
	private UserService userService;
	

	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser( @RequestBody @Valid User user)
	{

		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllUser(){return userService.getAllUser();}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id)
	{
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);		
	}
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public String deleteUser (@PathVariable("id") int id) {
		userService.deleteUser(id);
		return  "Successfully Deleted";
	}
}
