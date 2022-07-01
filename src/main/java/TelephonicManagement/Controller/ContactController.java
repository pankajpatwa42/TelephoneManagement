package TelephonicManagement.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TelephonicManagement.Models.Contacts;
import TelephonicManagement.Services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/getContactsByUser/{userid}")
	public List<Contacts> getContactsByUser(@PathVariable("userid") Integer userid ){
		return contactService.getContactsByUser(userid);
		 
	}
	
	@PostMapping("/savecontact/{userid}")
	public ResponseEntity<Contacts> saveContact( @Valid  @PathVariable("userid")Integer userid, @RequestBody Contacts contacts)
	{
		return new ResponseEntity<Contacts>(contactService.saveContact(contacts,userid),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Contacts> getAllContact(){return contactService.gatAllContacts();}
	
	@GetMapping("{id}")
	public ResponseEntity<Contacts> getContactById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Contacts>(contactService.getContactById(id),HttpStatus.OK);		
	}
	@PutMapping("{id}")
	public ResponseEntity<Contacts> updateContact(@Valid @PathVariable("id") int id,@RequestBody Contacts contacts)
	{
		return new ResponseEntity<Contacts>(contactService.updateContact(contacts,id),HttpStatus.OK);		
	}
	
	@DeleteMapping("{id}")
	public String deleteContact (@PathVariable("id") int id) {
		contactService.deleteContact(id);;
		return  "Successfully Deleted";
	}
}
