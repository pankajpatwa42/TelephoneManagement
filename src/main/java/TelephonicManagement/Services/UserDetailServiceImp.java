package TelephonicManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import TelephonicManagement.Repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));
//		()-> new userNameNotFound("Username or Password is invalid"));
	}

}
