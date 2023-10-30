public class Customer {
    String name;
    String phone;
    Address ad;

    public Customer(String name, String phone, Address ad) {
        this.name = name;
        this.phone = phone;
        this.ad = ad;
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

    public Address getAd() {
        return ad;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }
}
