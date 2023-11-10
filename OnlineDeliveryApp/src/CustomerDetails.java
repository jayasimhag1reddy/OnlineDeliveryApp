import java.util.HashMap;

public class CustomerDetails {

    private HashMap<String,Customer> hm = new HashMap<>();
    Customer cs;

    public CustomerDetails() {

    }
    public void setCust(String userid,Customer cs){
        hm.put(userid,cs);
    }
    public Customer getCust(String userid){
        return  hm.get(userid);
    }
    public boolean isValidCustomer(String user_id){
        return hm.containsKey(user_id);
    }

    public HashMap<String, Customer> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, Customer> hm) {
        this.hm = hm;
    }
}
