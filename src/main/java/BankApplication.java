import java.util.ArrayList;
import java.util.List;

/**
 * The BankApplication class represents a bank application that manages accounts and provides banking functionality.
 */
class BankApplication {
    private final List<Account> accounts;

    /**
     * Constructor to initialize a BankApplication object with an empty list of accounts.
     */
    public BankApplication() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Creates a new account with the provided information and adds it to the list of accounts.
     *
     * @param username        The account username
     * @param password        The account password
     * @param savingBalance   The initial saving balance
     * @param checkingBalance The initial checking balance
     * @return The created account
     */
    public Account createAccount(String username, String password, double savingBalance, double checkingBalance) {
        Account account = new Account(username, password, savingBalance, checkingBalance);
        accounts.add(account);
        return account;
    }

    /**
     * Logs in to an existing account using the provided account ID and password.
     *
     * @param username The account ID
     * @param password  The account password
     * @return The logged-in account, or null if the credentials are invalid
     */
    public Account login(String username, String password) {
        for (Account account : accounts) {
            if (account.validateCredentials(username, password)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Displays the account balances for the provided account.
     *
     * @param account The account to display balances for
     */
    public void displayBalances(Account account) {
        System.out.println("Account ID: " + account.getAccountID());
        System.out.println("Saving Balance: " + account.getSavingBalance());
        System.out.println("Checking Balance: " + account.getCheckingBalance());
    }

    /**
     * Displays the account information and user information for the provided account.
     *
     * @param account The account to display information for
     */
    public void displayAccountInfo(Account account) {
        System.out.println("Account ID: " + account.getAccountID());

        System.out.println("Users:");
        List<User> users = account.getUsers();
        for (User user : users) {
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Phone Number: " + user.getPhoneNum());
            System.out.println("Email: " + user.getEmail());
            System.out.println("SSN: " + user.getSsn());
            System.out.println("Date of Birth: " + user.getDob());
            System.out.println("Address: " + user.getAddress());
        }
    }

    /**
     * Removes a user from an account.
     *
     * @param user    The user to be removed
     * @param account The account to remove the user from
     */
    public void removeUserFromAccount(Account account, User user) {
        account.removeUser(user);
    }
}
