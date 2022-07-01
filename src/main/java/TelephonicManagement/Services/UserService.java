package TelephonicManagement.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import TelephonicManagement.Models.User;



public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUserById(int id);
	
	User updateUser(User user,int id);
	
	void deleteUser(int id);
	

	
}
