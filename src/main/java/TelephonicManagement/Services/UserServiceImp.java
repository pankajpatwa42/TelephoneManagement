package TelephonicManagement.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TelephonicManagement.Exception.ResourceNotFoundException;
import TelephonicManagement.Models.Role;
import TelephonicManagement.Models.User;
import TelephonicManagement.Repository.RoleRepository;
import TelephonicManagement.Repository.UserRepository;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User saveUser(User user) {
		Role role = roleRepository.findById(1).orElseThrow(null);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("USER", "id", id));
	}

	@Override
	public User updateUser(User user, int id) {
		User existinguser = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("USER", "id", id));
		existinguser.setName(user.getName());
		existinguser.setPassword(user.getPassword());
		existinguser.setEmail(user.getEmail());
//		existinguser.setSetRole(user.getSetRole());
		userRepository.save(existinguser);
		return existinguser;
	}

	@Override
	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("USER", "ID", id));
		userRepository.delete(user);
//		userRepository.deleteById(id);
	}
	
	
	

}
