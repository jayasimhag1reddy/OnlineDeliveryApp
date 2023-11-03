import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Homepage {
    Scanner sc;
    Item it;
    Customer cs;
    private double cost=0.0;
    private List<ItemList> order;
    public Homepage(){
        sc=new Scanner(System.in);
        it=new Item();
        cs=new Customer();
        order=new ArrayList<>();

    }
    public void display(){
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
                    Order();
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

    private void Order() {
        viewMenu();
        while(true) {
            try {
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                if(it.hm.containsKey(choice)){
                    System.out.println("Enter the Quantity");
                    int qnt=sc.nextInt();
                    cost+=(qnt*(it.hm.get(choice).getCost()));
                    order.add(new ItemList(it.hm.get(choice).getName(),qnt,qnt*(it.hm.get(choice).getCost())));
                }
                else{
                    System.out.println("Invalid Choice, Please Enter a valid choice");
                }
                System.out.println("Total Cost:"+cost+"$");
                System.out.println("Do you want to order more, Press Y/y to continue &  Press N/n to Checkout");
                char ext=sc.next().charAt(0);
                if(ext=='N' || ext=='n'){
                    orderCheckout();
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid choice");
                sc.next();
            }
        }



    }

    private void orderCheckout() {
        while (true) {
            try {
                System.out.println("Enter your choice");
                System.out.println("Type 1: View Order Details");
                System.out.println("Type 2: Edit the Order");
                System.out.println("Type 3: Complete the Order");
                int order_choice = sc.nextInt();
                if (order_choice == 1) {
                    viewOrder();
                }
                else if (order_choice == 2) {
                    editOrder();
                }
                else if (order_choice == 3) {
                    placeOrder();
                    break;
                }
                else if (order_choice < 1 || order_choice > 3) {
                    System.out.println("Invalid Choice, Please Enter  a valid choice");
                }
            }
            catch (Exception e){
                System.out.println("Invalid Choice, Please Enter  a valid choice");
                sc.next();
            }
        }
    }

    private void placeOrder() {

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
        for(int s:it.hm.keySet()){
            System.out.println(it.hm.get(s).getName()+"->"+it.hm.get(s).getCost());
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
                order.get(in).cost = q * (it.hm.get(in).getCost());
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
