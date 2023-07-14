import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The UserTest class contains unit tests for the User class.
 */
public class UserTest {

    /**
     * Test case for the getFirstName() method.
     * It creates an instance of the User class and retrieves the user's first name.
     * The expected first name is "John".
     */
    @Test
    public void testGetFirstName() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's first name
        String firstName = user.getFirstName();

        // Assert that the returned first name matches the expected value
        Assertions.assertEquals("John", firstName);
    }

    /**
     * Test case for the getLastName() method.
     * It creates an instance of the User class and retrieves the user's last name.
     * The expected last name is "Doe".
     */
    @Test
    public void testGetLastName() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's last name
        String lastName = user.getLastName();

        // Assert that the returned last name matches the expected value
        Assertions.assertEquals("Doe", lastName);
    }

    /**
     * Test case for the getPhoneNum() method.
     * It creates an instance of the User class and retrieves the user's phone number.
     * The expected phone number is "1234567890".
     */
    @Test
    public void testGetPhoneNum() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's phone number
        String phoneNum = user.getPhoneNum();

        // Assert that the returned phone number matches the expected value
        Assertions.assertEquals("1234567890", phoneNum);
    }

    /**
     * Test case for the getEmail() method.
     * It creates an instance of the User class and retrieves the user's email.
     * The expected email is "johndoe@example.com".
     */
    @Test
    public void testGetEmail() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's email
        String email = user.getEmail();

        // Assert that the returned email matches the expected value
        Assertions.assertEquals("johndoe@example.com", email);
    }

    /**
     * Test case for the getSsn() method.
     * It creates an instance of the User class and retrieves the user's SSN.
     * The expected SSN is "123456789".
     */
    @Test
    public void testGetSsn() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's SSN
        String ssn = user.getSsn();

        // Assert that the returned SSN matches the expected value
        Assertions.assertEquals("123456789", ssn);
    }

    /**
     * Test case for the getDob() method.
     * It creates an instance of the User class and retrieves the user's date of birth.
     * The expected date of birth is "01/01/1990".
     */
    @Test
    public void testGetDob() {
        // Create an instance of the User class
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the user's date of birth
        String dob = user.getDob();

        // Assert that the returned date of birth matches the expected value
        Assertions.assertEquals("01/01/1990", dob);
    }

    /**
     * Test case for the getAddress() method.
     * It creates an instance of the User class with a specific address
     * and retrieves the formatted address using the getAddress() method.
     * The expected formatted address is "123 Main St, City, NY 12345".
     */
    @Test
    public void testGetAddress() {
        // Create an instance of the User class with a specific address
        User user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));

        // Get the formatted address using the getAddress() method
        String userAddress = user.getAddress();

        // Assert that the returned address matches the expected format
        String expectedAddress = "123 Main St, City, NY 12345";
        Assertions.assertEquals(expectedAddress, userAddress);
    }
}
