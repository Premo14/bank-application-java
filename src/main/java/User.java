/**
 * The User class represents a user with personal information and an address.
 */
class User {
    private final String firstName;
    private final String lastName;
    private final String phoneNum;
    private final String email;
    private final String ssn;
    private final String dob;
    private final Address address;

    /**
     * Constructor to initialize a User object with the provided information.
     *
     * @param firstName The user's first name
     * @param lastName  The user's last name
     * @param phoneNum  The user's phone number
     * @param email     The user's email address
     * @param ssn       The user's Social Security Number
     * @param dob       The user's date of birth (in the format xx/xx/xxxx)
     * @param address   The user's address
     */
    public User(String firstName, String lastName, String phoneNum, String email,
                String ssn, String dob, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.ssn = ssn;
        this.dob = dob;
        this.address = address;
    }

    /**
     * Returns the user's first name.
     *
     * @return The user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return The user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the user's phone number.
     *
     * @return The user's phone number
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Returns the user's email address.
     *
     * @return The user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's Social Security Number.
     *
     * @return The user's Social Security Number
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Returns the user's date of birth.
     *
     * @return The user's date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Returns the user's formatted address.
     *
     * @return The user's formatted address
     */
    public String getAddress() {
        return address.getFormattedAddress();
    }
}
