package TelephonicManagement.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TelephonicManagement.Exception.ResourceNotFoundException;
import TelephonicManagement.Models.Contacts;
import TelephonicManagement.Models.User;
import TelephonicManagement.Repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contacts saveContact(Contacts contacts ,Integer Userid) {
		User user = userService.getUserById(Userid);
		contacts.setUser(user);
		return contactRepository.save(contacts);
	}

	@Override
	public List<Contacts> gatAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contacts getContactById(int id) {
		return contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CONTACT", "id", id));
	}

	@Override
	public void deleteContact(int id) {
		Contacts contacts = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CONTACT", "ID", id));
		contactRepository.delete(contacts);
//		contactRepository.deleteById(id);
		
	}
	

	@Override
	public List<Contacts> getContactsByUser(Integer userid) {
		User user = userService.getUserById(userid);
		return contactRepository.findByUser(user);
		 
	}

	@Override
	public Contacts updateContact(Contacts contacts, int id) {
		Contacts ExistingContact = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CONTACT", "ID", id));
		ExistingContact.setName(contacts.getName());
		ExistingContact.setEmail(contacts.getEmail());
		ExistingContact.setPhone(contacts.getPhone());
		ExistingContact.setWork(contacts.getWork());
		contactRepository.save(ExistingContact);
		return ExistingContact;
	}

}
