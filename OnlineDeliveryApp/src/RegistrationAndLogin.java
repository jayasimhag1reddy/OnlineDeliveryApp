import java.util.HashMap;
import java.util.Scanner;

public class RegistrationAndLogin {

    Scanner sc;
    Customer c;

    public RegistrationAndLogin() {

        sc = new Scanner(System.in);
        c=new Customer();
    }

    public void registration() {
        System.out.println("Please Enter a unique UserId:");
        String userid = sc.nextLine();
        while (c.hm.containsKey(userid)) {
            System.out.println(userid + " This is already taken,Please enter another one");
            userid = sc.nextLine();
        }
        System.out.println("Please Enter your Password:");
        String password = sc.nextLine();
        System.out.println("Please Enter your Name:");
        String name = sc.nextLine();
        System.out.println("Please Enter your Phone Number:");
        String phone = sc.nextLine();
        while (!isValid(phone)) {
            System.out.println("Invalid Phone number,Please Enter a valid phone number:");
            phone = sc.nextLine();
        }
        System.out.println("Please Enter  Address");
        System.out.println("Please Enter your Street address:");
        String street = sc.nextLine();
        System.out.println("Please Enter your City:");
        String city = sc.nextLine();
        System.out.println("Please Enter your pincode:");
        String pincode = sc.nextLine();
        System.out.println("Please Enter your state:");
        String state = sc.nextLine();
        Address ad = new Address(street, city, pincode, state);
        Customer cs = new Customer(userid, password, name, phone, ad);
        c.acceptCst(userid,cs);
        System.out.println("Registration Successful");
    }

    private boolean isValid(String phone) {
        if (phone.length() != 10) return false;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void login() {
        System.out.println("Please Enter your UserID");
        String userid = sc.nextLine();
        while (!c.hm.containsKey(userid)) {
            System.out.println("Invalid userId, Please Enter a valid userid");
            userid = sc.nextLine();
        }
        System.out.println("Please Enter your PassWord");
        String password = sc.nextLine();
        while (!c.hm.get(userid).getPassword().equals(password)) {
            System.out.println("Invalid Password, Please enter a valid password");
            password = sc.nextLine();
        }
        System.out.println("Login success");
        Homepage hp=new Homepage();
        hp.display();
    }

}
