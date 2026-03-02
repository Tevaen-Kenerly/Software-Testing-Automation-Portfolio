package contact.java;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();
// add new contact
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null.");
		}
		String contactId = contact.getContactId();
		if (contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID already exist.");
		}
		contacts.put(contactId,contact);
	}
// delete a contact by ID
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		contacts.remove(contactId);
	}
// update contact fields by ID
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		contact.setFirstName(firstName);
		contact.setLastName(lastName);;
		contact.setPhone(phone);;
		contact.setAddress(address);
	}
}
