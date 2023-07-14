/**
 * The Address class represents a physical address with street, city, state, and zip code.
 */
class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    /**
     * Constructor to initialize the address with the given values.
     *
     * @param street The street name
     * @param city   The city name
     * @param state  The state name
     * @param zip    The zip code
     */
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    /**
     * Returns the formatted address in standard address format.
     *
     * @return The formatted address
     */
    public String getFormattedAddress() {
        return street + ", " + city + ", " + state + " " + zip;
    }
}
