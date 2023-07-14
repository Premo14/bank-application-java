import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * The BankApplicationTest class contains unit tests for the BankApplication class.
 */
public class BankApplicationTest {
    private BankApplication bankApp;
    private Account account;
    private ByteArrayOutputStream outputStream;
    private User userToRemove;

    @BeforeEach
    public void setup() {
        // Create a new BankApplication instance and an Account for testing
        bankApp = new BankApplication();
        account = bankApp.createAccount("johndoe", "password", 1000.0, 2000.0);
        userToRemove = new User("John", "Doe", "1234567890", "johndoe@example.com", "123-45-6789", "01/01/2000", new Address("123 Main St", "City", "State", "12345"));
        account.addUser(userToRemove);

        // Create a ByteArrayOutputStream to capture console output
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Test the createAccount() method of the BankApplication class.
     * It verifies that an account is successfully created with the specified details.
     */
    @Test
    public void testCreateAccount() {
        // Test the createAccount() method
        Assertions.assertNotNull(account);
        Assertions.assertEquals("johndoe", account.getUsername());
        Assertions.assertEquals("password", account.getPassword());
        Assertions.assertEquals(1000.0, account.getSavingBalance());
        Assertions.assertEquals(2000.0, account.getCheckingBalance());
    }

    /**
     * Test the login() method of the BankApplication class with valid credentials.
     * It verifies that a valid account is returned for the provided account ID and password.
     */
    @Test
    public void testLoginValidCredentials() {
        // Test the login() method with valid credentials
        Account loggedInAccount = bankApp.login(account.getAccountID(), "password");
        Assertions.assertNotNull(loggedInAccount);
        Assertions.assertEquals(account.getAccountID(), loggedInAccount.getAccountID());
    }

    /**
     * Test the login() method of the BankApplication class with invalid credentials.
     * It verifies that null is returned when invalid credentials are provided.
     */
    @Test
    public void testLoginInvalidCredentials() {
        // Test the login() method with invalid credentials
        Account loggedInAccount = bankApp.login(account.getAccountID(), "wrongPassword");
        Assertions.assertNull(loggedInAccount);
    }

    /**
     * Test the displayBalances() method of the BankApplication class.
     * It verifies that the account balances are correctly displayed in the console output.
     */
    @Test
    public void testDisplayBalances() {
        // Test the displayBalances() method
        bankApp.displayBalances(account);
        String consoleOutput = outputStream.toString().trim();

        // Assert that the console output contains the expected information
        Assertions.assertTrue(consoleOutput.contains("Account ID: " + account.getAccountID()));
        Assertions.assertTrue(consoleOutput.contains("Saving Balance: 1000.0"));
        Assertions.assertTrue(consoleOutput.contains("Checking Balance: 2000.0"));
    }

    /**
     * Test the displayAccountInfo() method of the BankApplication class.
     * It verifies that the account information, including user details, is correctly displayed in the console output.
     */
    @Test
    public void testDisplayAccountInfo() {
        // Create a User and add it to the account for testing
        User user = new User("John", "Doe", "1234567890", "john.doe@example.com", "123-45-6789", "01/01/2000", new Address("123 Main St", "City", "State", "12345"));
        account.addUser(user);

        // Test the displayAccountInfo() method
        bankApp.displayAccountInfo(account);
        String consoleOutput = outputStream.toString().trim();

        // Assert that the console output contains the expected information
        Assertions.assertTrue(consoleOutput.contains("Account ID: " + account.getAccountID()));
        Assertions.assertTrue(consoleOutput.contains("Users:"));
        Assertions.assertTrue(consoleOutput.contains("First Name: John"));
        Assertions.assertTrue(consoleOutput.contains("Last Name: Doe"));
        Assertions.assertTrue(consoleOutput.contains("Phone Number: 1234567890"));
        Assertions.assertTrue(consoleOutput.contains("Email: john.doe@example.com"));
        Assertions.assertTrue(consoleOutput.contains("SSN: 123-45-6789"));
        Assertions.assertTrue(consoleOutput.contains("Date of Birth: 01/01/2000"));
        Assertions.assertTrue(consoleOutput.contains("Address: 123 Main St, City, State 12345"));
    }

    /**
     * Test the removeUserFromAccount() method of the BankApplication class.
     * It verifies that a user is successfully removed from the account's user list.
     */
    @Test
    public void testRemoveUserFromAccount() {
        bankApp.removeUserFromAccount(account, userToRemove);

        List<User> users = account.getUsers();

        Assertions.assertFalse(users.contains(userToRemove));
    }
}
