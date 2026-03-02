package contact.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("001", "Ira", "Doe", "1234567890", "123 Street");
		
		service.addContact(contact);
	}
	
	@Test
	void testAddDuplicateContactId() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("001", "Ira","Doe", "1234567890", "123 Street");
		Contact contact2 = new Contact("001", "Czen", "Good","0987654321", "1234 Street");
		
		service.addContact(contact1);
	
		assertThrows(IllegalArgumentException.class, ()->{
			service.addContact(contact2);
		});
	}
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("002", "Jim", "Beats","1234567890","321  Street");
		
		service.addContact(contact);
		service.deleteContact("002");
	}
	@Test 
	void testDeleteNonExistentContact() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, ()->{
			service.deleteContact("999");
		});
	}
	@Test
	void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("003", "Sam", "Adam","7418520963", "Old Address");
		
		service.addContact(contact);;
		service.updateContact("003","Samuel", "Adams","7410258963","New Address");
		
		assertEquals("Samuel", contact.getFirstName());
		assertEquals("Adams", contact.getLastName());
		assertEquals("7418520963", contact.getPhone());
		assertEquals("New Address", contact.getAddress());
	}
	@Test
	void testUpdateNonExistentContact() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, ()->{
			service.updateContact("888","A", "B","1234567890", "Address"); 
		});
	}
	
}
