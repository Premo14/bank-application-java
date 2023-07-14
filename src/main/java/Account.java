import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Account class represents a bank account with associated users and balances.
 */
class Account {
    private static final int ACCOUNT_ID_LENGTH = 10;
    private static final String ACCOUNT_ID_CHARS = "0123456789";

    private static final List<String> usedAccountIDs = new ArrayList<>();

    private final List<User> users;
    private final String accountID;
    private String username;
    private String password;
    private double savingBalance;
    private double checkingBalance;

    /**
     * Constructor to initialize an Account object with the provided information.
     *
     * @param password        The account password
     * @param username        The account username
     * @param savingBalance   The initial saving balance
     * @param checkingBalance The initial checking balance
     */
    public Account(String username, String password, double savingBalance, double checkingBalance) {
        this.users = new ArrayList<>();
        this.accountID = generateUniqueAccountID();
        this.username = username;
        this.password = password;
        this.savingBalance = savingBalance;
        this.checkingBalance = checkingBalance;
    }

    /**
     * Generates a unique account ID for the account.
     *
     * @return The generated account ID
     */
    private String generateUniqueAccountID() {
        String accountID;
        Random random = new Random();
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ACCOUNT_ID_LENGTH; i++) {
                int index = random.nextInt(ACCOUNT_ID_CHARS.length());
                sb.append(ACCOUNT_ID_CHARS.charAt(index));
            }
            accountID = sb.toString();
        } while (usedAccountIDs.contains(accountID));

        usedAccountIDs.add(accountID);
        return accountID;
    }

    /**
     * Adds a user to the account.
     *
     * @param user The user to be added
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Validates the account credentials.
     *
     * @param username The account ID to validate
     * @param password  The account password to validate
     * @return True if the credentials are valid, false otherwise
     */
    public boolean validateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    /**
     * Returns The username of the account
     *
     * @return The username of the account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the account
     *
     * @param username The username of the account
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the account
     *
     * @return The password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a new password for the account
     *
     * @param newPassword The new password for the account
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * Returns the account ID.
     *
     * @return The account ID
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Returns the saving balance.
     *
     * @return The saving balance
     */
    public double getSavingBalance() {
        return savingBalance;
    }

    /**
     * Returns the checking balance.
     *
     * @return The checking balance
     */
    public double getCheckingBalance() {
        return checkingBalance;
    }

    /**
     * Returns the list of users associated with the account.
     *
     * @return The list of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Deposits an amount to the saving balance.
     *
     * @param amount The amount to deposit
     */
    public void depositToSaving(double amount) {
        savingBalance += amount;
    }

    /**
     * Deposits an amount to the checking balance.
     *
     * @param amount The amount to deposit
     */
    public void depositToChecking(double amount) {
        checkingBalance += amount;
    }

    /**
     * Withdraws an amount from the saving balance.
     *
     * @param amount The amount to withdraw
     */
    public void withdrawFromSaving(double amount) {
        if (amount <= savingBalance) {
            savingBalance -= amount;
        } else {
            System.out.println("Insufficient funds in the saving account.");
        }
    }
    /**
     * Withdraws an amount from the checking balance.
     *
     * @param amount The amount to withdraw
     */
    public void withdrawFromChecking(double amount) {
        if (amount <= checkingBalance) {
            checkingBalance -= amount;
        } else {
            System.out.println("Insufficient funds in the checking account.");
        }
    }

    /**
     * Transfers funds from the checking account to the saving account.
     *
     * @param amount The amount to transfer
     */
    public void transferToSaving(double amount) {
        if (amount <= checkingBalance) {
            checkingBalance -= amount;
            savingBalance += amount;
        } else {
            System.out.println("Insufficient funds in the checking account.");
        }
    }

    public void transferToChecking(double amount) {
        if (amount <= checkingBalance) {
            savingBalance -= amount;
            checkingBalance += amount;
        } else {
            System.out.println("Insufficient funds in the checking account.");
        }
    }

    /**
     * Transfers funds from one account to another account.
     *
     * @param amount    The amount to transfer
     * @param recipient The recipient account
     */
    public void transferToAccount(double amount, Account recipient) {
        if (amount <= checkingBalance) {
            checkingBalance -= amount;
            recipient.depositToChecking(amount);
        } else {
            System.out.println("Insufficient funds in the checking account.");
        }
    }

    /**
     * Removes a user from the account.
     *
     * @param user The user to remove
     */
    public void removeUser(User user) {
        users.remove(user);
    }
}
