public class Customer {

    private String userId;
    private String password;
    private String name;
    private String phone;
    private int loc;

    public Customer(String userId, String password, String name, String phone, int loc) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.loc = loc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }
}
