import org.junit.jupiter.api.Test;

/**
 * The AddressTest class contains unit tests for the Address class.
 */
public class AddressTest {

    /**
     * Test the getStreet() method of the Address class.
     * It ensures that the street value is returned correctly.
     */
    @Test
    public void testGetStreet() {
        // Create an instance of the Address class
        Address address = new Address("123 Main St", "City", "NY", "12345");

        // Get the street value
        String street = address.getStreet();

        // Assert that the returned street value matches the expected value
        Assertions.assertEquals("123 Main St", street);
    }

    /**
     * Test the getCity() method of the Address class.
     * It ensures that the city value is returned correctly.
     */
    @Test
    public void testGetCity() {
        // Create an instance of the Address class
        Address address = new Address("123 Main St", "City", "NY", "12345");

        // Get the city value
        String city = address.getCity();

        // Assert that the returned city value matches the expected value
        Assertions.assertEquals("City", city);
    }

    /**
     * Test the getState() method of the Address class.
     * It ensures that the state value is returned correctly.
     */
    @Test
    public void testGetState() {
        // Create an instance of the Address class
        Address address = new Address("123 Main St", "City", "NY", "12345");

        // Get the state value
        String state = address.getState();

        // Assert that the returned state value matches the expected value
        Assertions.assertEquals("NY", state);
    }

    /**
     * Test the getZip() method of the Address class.
     * It ensures that the ZIP code value is returned correctly.
     */
    @Test
    public void testGetZip() {
        // Create an instance of the Address class
        Address address = new Address("123 Main St", "City", "NY", "12345");

        // Get the ZIP code value
        String zip = address.getZip();

        // Assert that the returned ZIP code value matches the expected value
        Assertions.assertEquals("12345", zip);
    }

    /**
     * Test the {@code getFormattedAddress()} method of the {@code Address} class.
     * It ensures that the formatted address is generated correctly with the expected format.
     */
    @Test
    public void testGetFormattedAddress() {
        // Create an instance of the Address class
        Address address = new Address("123 Main St", "City", "NY", "12345");

        // Get the formatted address
        String formattedAddress = address.getFormattedAddress();

        // Assert that the formatted address matches the expected format
        String expectedAddress = "123 Main St, City, NY 12345";
        Assertions.assertEquals(expectedAddress, formattedAddress);
    }
}
