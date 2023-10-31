import java.util.HashMap;

public class Customer {
    private String userid;
    private String password;
    private String name;
    private String phone;
    private Address ad;

    public HashMap<String, Customer> hm;
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Customer(){
        hm=new HashMap<>();
    }
    public Customer(String userid, String password, String name, String phone, Address ad) {
        this.userid=userid;
        this.password=password;
        this.name = name;
        this.phone = phone;
        this.ad = ad;
    }

    public void acceptCst(String userid,Customer cs){
        hm.put(userid,cs);
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
