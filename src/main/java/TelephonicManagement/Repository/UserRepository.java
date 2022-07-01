package TelephonicManagement.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import TelephonicManagement.Models.User;




public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<TelephonicManagement.Models.User> findByEmail(String email);

}
