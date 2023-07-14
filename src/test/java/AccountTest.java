import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The AccountTest class contains unit tests for the Account class.
 */
public class AccountTest {
    private Account account;
    private User user;

    @BeforeEach
    public void setUp() {
        // Create an account and add a user for testing
        account = new Account("john123", "password", 1000.0, 500.0);
        user = new User("John", "Doe", "1234567890", "johndoe@example.com",
                "123456789", "01/01/1990", new Address("123 Main St", "City", "NY", "12345"));
        account.addUser(user);
    }

    /**
     * Test the getUsername() method of the Account class.
     * It verifies that the correct username is returned.
     */
    @Test
    public void testGetUsername() {
        // Test the getUsername() method
        String username = account.getUsername();
        Assertions.assertEquals("john123", username);
    }

    /**
     * Test the setUsername() method of the Account class.
     * It verifies that the username is successfully set.
     */
    @Test
    public void testSetUsername() {
        // Test the setUsername() method
        account.setUsername("john.doe");
        String username = account.getUsername();
        Assertions.assertEquals("john.doe", username);
    }

    /**
     * Test the getPassword() method of the Account class.
     * It verifies that the correct password is returned.
     */
    @Test
    public void testGetPassword() {
        // Test the getPassword() method
        String password = account.getPassword();
        Assertions.assertEquals("password", password);
    }

    /**
     * Test the setPassword() method of the Account class.
     * It verifies that the password is successfully set.
     */
    @Test
    public void testSetPassword() {
        // Test the setPassword() method
        account.setPassword("newPassword");
        String password = account.getPassword();
        Assertions.assertEquals("newPassword", password);
    }

    /**
     * Test the getAccountID() method of the Account class.
     * It verifies that the account ID is returned with the correct length.
     */
    @Test
    public void testGetAccountID() {
        // Test the getAccountID() method
        String accountID = account.getAccountID();
        Assertions.assertEquals(10, accountID.length());
    }

    /**
     * Test the getSavingBalance() method of the Account class.
     * It verifies that the correct saving balance is returned.
     */
    @Test
    public void testGetSavingBalance() {
        // Test the getSavingBalance() method
        double savingBalance = account.getSavingBalance();
        Assertions.assertEquals(1000.0, savingBalance);
    }

    /**
     * Test the getCheckingBalance() method of the Account class.
     * It verifies that the correct checking balance is returned.
     */
    @Test
    public void testGetCheckingBalance() {
        // Test the getCheckingBalance() method
        double checkingBalance = account.getCheckingBalance();
        Assertions.assertEquals(500.0, checkingBalance);
    }

    /**
     * Test the getUsers() method of the Account class.
     * It verifies that the list of users in the account is returned correctly.
     */
    @Test
    public void testGetUsers() {
        // Test the getUsers() method
        List<User> users = account.getUsers();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user, users.get(0));
    }

    /**
     * Test the depositToSaving() method of the Account class.
     * It ensures that the deposit of funds to the saving balance is performed correctly.
     */
    @Test
    public void testDepositToSaving() {
        // Test the depositToSaving() method
        account.depositToSaving(200.0);
        double savingBalance = account.getSavingBalance();

        // Assert that the deposit was performed correctly
        Assertions.assertEquals(1200.0, savingBalance);
    }

    /**
     * Test the depositToChecking() method of the Account class.
     * It ensures that the deposit of funds to the checking balance is performed correctly.
     */
    @Test
    public void testDepositToChecking() {
        // Test the depositToChecking() method
        account.depositToChecking(100.0);
        double checkingBalance = account.getCheckingBalance();

        // Assert that the deposit was performed correctly
        Assertions.assertEquals(600.0, checkingBalance);
    }

    /**
     * Test the withdrawFromSaving() method of the Account class with sufficient funds.
     * It ensures that the withdrawal of funds from the saving balance is performed correctly when sufficient funds are available.
     */
    @Test
    public void testWithdrawFromSavingSufficientFunds() {
        // Test the withdrawFromSaving() method with sufficient funds
        account.withdrawFromSaving(300.0);
        double savingBalance = account.getSavingBalance();

        // Assert that the withdrawal was performed correctly
        Assertions.assertEquals(700.0, savingBalance);
    }

    /**
     * Test the withdrawFromSaving() method of the Account class with insufficient funds.
     * It ensures that the withdrawal of funds from the saving balance is handled correctly when insufficient funds are available.
     */
    @Test
    public void testWithdrawFromSavingInsufficientFunds() {
        // Test the withdrawFromSaving() method with insufficient funds
        account.withdrawFromSaving(1500.0);
        double savingBalance = account.getSavingBalance();

        // Assert that the saving balance remains unchanged
        Assertions.assertEquals(1000.0, savingBalance);
    }

    /**
     * Test the withdrawFromChecking() method of the Account class with sufficient funds.
     * It ensures that the withdrawal of funds from the checking balance is performed correctly when sufficient funds are available.
     */
    @Test
    public void testWithdrawFromCheckingSufficientFunds() {
        // Test the withdrawFromChecking() method with sufficient funds
        account.withdrawFromChecking(200.0);
        double checkingBalance = account.getCheckingBalance();

        // Assert that the withdrawal was performed correctly
        Assertions.assertEquals(300.0, checkingBalance);
    }

    /**
     * Test the withdrawFromChecking() method of the Account class with insufficient funds.
     * It ensures that the withdrawal of funds from the checking balance is handled correctly when insufficient funds are available.
     */
    @Test
    public void testWithdrawFromCheckingInsufficientFunds() {
        // Test the withdrawFromChecking() method with insufficient funds
        account.withdrawFromChecking(800.0);
        double checkingBalance = account.getCheckingBalance();

        // Assert that the checking balance remains unchanged
        Assertions.assertEquals(500.0, checkingBalance);
    }

    /**
     * Test the transferToAccount() method of the Account class.
     * It ensures that the transfer of funds from the current account to a recipient account is performed correctly.
     */
    @Test
    public void testTransferToAccount() {
        // Create a recipient account for testing
        Account recipient = new Account("janedoe", "password", 500.0, 300.0);

        // Test the transferToAccount() method
        account.transferToAccount(200.0, recipient);
        double checkingBalance = account.getCheckingBalance();
        double recipientCheckingBalance = recipient.getCheckingBalance();

        // Assert that the transfer was performed correctly
        Assertions.assertEquals(300.0, checkingBalance);
        Assertions.assertEquals(500.0, recipientCheckingBalance);
    }

    /**
     * Test the removeUser() method of the Account class.
     * It ensures that a user can be successfully removed from the account.
     */
    @Test
    public void testRemoveUser() {
        // Test the removeUser() method
        account.removeUser(user);
        List<User> users = account.getUsers();

        // Assert that the user is removed from the account
        Assertions.assertTrue(users.isEmpty());
    }

    /**
     * Test the transferToSaving() method of the Account class.
     * It verifies that an amount is successfully transferred from the checking balance to the saving balance.
     */
    @Test
    public void testTransferToSaving() {
        double transferAmount = 200.0;
        double expectedCheckingBalance = account.getCheckingBalance() - transferAmount;
        double expectedSavingBalance = account.getSavingBalance() + transferAmount;

        account.transferToSaving(transferAmount);

        double actualCheckingBalance = account.getCheckingBalance();
        double actualSavingBalance = account.getSavingBalance();

        Assertions.assertEquals(expectedCheckingBalance, actualCheckingBalance);
        Assertions.assertEquals(expectedSavingBalance, actualSavingBalance);
    }

    /**
     * Test the transferToChecking() method of the Account class.
     * It ensures that the transfer of funds from the saving balance to the checking balance within the same account
     * is performed correctly.
     */
    @Test
    public void testTransferToChecking() {
        account.transferToChecking(200.0);

        double savingBalance = account.getSavingBalance();
        double checkingBalance = account.getCheckingBalance();

        Assertions.assertEquals(800.0, savingBalance);
        Assertions.assertEquals(700.0, checkingBalance);
    }
}
