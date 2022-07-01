package TelephonicManagement.Services;



import java.util.List;


import TelephonicManagement.Models.Contacts;


public interface ContactService {
	
	List<Contacts> getContactsByUser(Integer userid);

	Contacts saveContact(Contacts contacts,Integer UserId);
	
	List<Contacts> gatAllContacts();
	
	Contacts getContactById(int id);
	
	Contacts updateContact(Contacts contacts,int id);
	
	void deleteContact(int id);
	
	
}
