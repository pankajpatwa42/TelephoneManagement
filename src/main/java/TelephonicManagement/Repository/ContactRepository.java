package TelephonicManagement.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TelephonicManagement.Models.Contacts;
import TelephonicManagement.Models.User;


public interface ContactRepository extends JpaRepository<Contacts,Integer>{
	List<Contacts> findByUser(User user);

}
