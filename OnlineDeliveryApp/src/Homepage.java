import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage {
    private Scanner sc=new Scanner(System.in);
    private ItemDetails it=new ItemDetails();
    private CustomerDetails cd=new CustomerDetails();
    private double cost=0.0;
    private List<ItemList> order=new ArrayList<>();
    public Homepage(){

    }
    public void registration() {
        System.out.println("Enter UserID: ");
        String userid=sc.nextLine();
        System.out.println("Enter Password: ");
        String password=sc.nextLine();
        System.out.println("Enter your Name: ");
        String name=sc.nextLine();
        System.out.println("Enter your Phone: ");
        String phone=sc.nextLine();
        System.out.println("Enter your Location number: ");
        int loc=sc.nextInt();
        System.out.println("Registration Successful");
        Customer cust=new Customer(userid,password,name,phone,loc);
        cd.setCust(userid,cust);
    }
    public void login() {
        System.out.println("Enter your UserID: ");
        String user_id=sc.nextLine();
        while(!cd.isValidCustomer(user_id)){
            System.out.println("Invalid UserId,Please try again: ");
            user_id=sc.nextLine();
        }
        System.out.println("Enter your Password: ");
        String password=sc.nextLine();
        while(!cd.getCust(user_id).getPassword().equals(password)){
            System.out.println("Invalid Password,Please try again: ");
            password=sc.nextLine();
        }
        System.out.println("Login Success");
        display(user_id);
    }
    public void display(String user_id){
        while(true) {
            try {
                System.out.println("Enter your choice");
                System.out.println("Type 1 : View Menu");
                System.out.println("Type 2 : Place an Order");
                System.out.println("Type 3 :Exit");
                int user_choice = sc.nextInt();
                if(user_choice==1){
                    viewMenu();
                }
                if(user_choice==2){
                    Order(user_id);
                }
                if(user_choice==3){
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid Choice, Please Enter a Valid choice");
                sc.next();
            }

        }
    }

    private void Order(String user_id) {
        viewMenu();
        while(true) {
            try {
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                if(it.getHm().containsKey(choice)){
                    System.out.println("Enter the Quantity");
                    int qnt=sc.nextInt();
                    cost+=(qnt*(it.getHm().get(choice).getCost()));
                    order.add(new ItemList(it.getHm().get(choice).getName(),qnt,qnt*(it.getHm().get(choice).getCost())));
                }
                else{
                    System.out.println("Invalid Choice, Please Enter a valid choice");
                }
                System.out.println("Total Cost:"+cost+"$");
                System.out.println("Do you want to order more, Press Y/y to continue &  Press N/n to Checkout");
                char ext=sc.next().charAt(0);
                if(ext=='N' || ext=='n'){
                    orderCheckout(user_id);
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid choice");
                sc.next();
            }
        }



    }

    private void orderCheckout(String user_id) {
        while (true) {
            try {
                System.out.println("Enter your choice");
                System.out.println("Type 1: View Order Details");
                System.out.println("Type 2: Edit the Order");
                System.out.println("Type 3: Add new Items");
                System.out.println("Type 4: Complete the Order");
                int order_choice = sc.nextInt();
                if (order_choice == 1) {
                    viewOrder();
                }
                else if (order_choice == 2) {
                    editOrder();
                }
                else if(order_choice==3){
                    Order(user_id);
                }
                else if (order_choice == 4) {
                    placeOrder(user_id);
                    break;
                }
                else if (order_choice < 1 || order_choice > 4) {
                    System.out.println("Invalid Choice, Please Enter  a valid choice");
                }
            }
            catch (Exception e){
                System.out.println("Invalid Choice, Please Enter  a valid choice");
                sc.next();
            }
        }
    }

    private void placeOrder(String user_id) {
        try {
            viewOrder();
            System.out.println(cd.getHm().get(user_id));
            ShortestDistance sd = new ShortestDistance();
            int d = sd.ClosePath(cd.getCust(user_id).getLoc());
            int time = (d / 20) * 60;
            System.out.println("Thanks for your order");
            System.out.println("It will be delivered in " + time + "Minutes");
        }
        catch (Exception e){
            System.out.println("Something is Wrong,Can't Place the order"+e);
        }
    }

    private void editOrder() {
        viewOrder();
        while(true){
            try {
                System.out.println("Enter the Item number you want to edit");
                int in = sc.nextInt();
                if (in>=1 && in <= order.size()) {
                    changeOrder(in);
                }
                if (in <= 0 || in > order.size()) {
                    System.out.println("Invalid Choice, Enter the number within the range of item list");
                }
            }
            catch (Exception e){
                System.out.println("Invalid Choice, Please Enter Valid Number");
                sc.next();
            }
        }

    }

    private void viewOrder() {
        System.out.println("Order Details");
        for(int i=0;i<order.size();i++){
            System.out.println((i+1)+" "+order.get(i).item+" "+order.get(i).qnt+" "+order.get(i).cost);
        }
    }

    private void viewMenu() {
        for(int s:it.getHm().keySet()){
            System.out.println(s+" "+it.getHm().get(s).getName()+"->"+it.getHm().get(s).getCost());
        }
    }
    private void changeOrder(int in){
        while(true) {
            System.out.println("Press 'R'/'r' to remove Item from order \n Press 'E'/'e' to edit the Quantity of the item \n Press 'Q'/'q' to Exit ");
            char ed = sc.next().charAt(0);
            if (ed == 'R' || ed == 'r') {
                cost-=order.get(in).cost;
                order.remove(in);
            }
            else if (ed == 'E' || ed == 'e') {
                System.out.println("Enter the quantity");
                int q = sc.nextInt();
                order.get(in).qnt = q;
                order.get(in).cost = q * (it.getHm().get(in).getCost());
            }
            else if (ed == 'Q' || ed == 'q') {
                break;
            }
            else{
                System.out.println("Please Enter a Valid choice");
            }
        }
    }

}
class ItemList{
    String item;
    int qnt;
    double cost;
    public ItemList(String item,int qnt,double cost){
        this.item=item;
        this.qnt=qnt;
        this.cost=cost;
    }
}
