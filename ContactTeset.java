package contact.java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTeset {
	@Test
	void testValidContactCreation() {
		Contact contact = new Contact("12345", "Tevaen", "Kenerly", "1234567890", "123 T's Street");
		
		assertEquals("12345", contact.getContactId());
		assertEquals("Tevaen", contact.getFirstName());
		assertEquals("Kenerly", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 T's Street", contact.getAddress());
	}
	
	@Test
	void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact(null, "Tevaen", "Kenerly", "1234567890", "123 T's Street");
		});
	}
	@Test
	void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345",null, "Kenerly","1234567890","123 T's Street");
		});
	}
	@Test
	void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345","Tevaen", null, "1234567890","123 T's Street");
		});
	}
	@Test
	void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Tevaen", "Kenerly",null, "123 T's Street");
		});
	}
	@Test
	void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Contact("12345", "Tevaen", "Kenerly", "1234567890", null);
		});
	}

}
