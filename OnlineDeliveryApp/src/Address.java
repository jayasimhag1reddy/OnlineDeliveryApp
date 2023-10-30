public class Address {
    private String Street;
    private String city;
    private String pin_code;
    private String state;
    public Address(String street, String city, String pin_code, String state) {
        Street = street;
        this.city = city;
        this.pin_code = pin_code;
        this.state = state;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
