import com.sun.source.tree.WhileLoopTree;

import java.util.HashMap;
import java.util.Scanner;

public class Homepage {
    Scanner sc;
    public Homepage(){
        sc=new Scanner(System.in);
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
                    placeOrder();
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

    private void placeOrder() {
        
    }

    private void viewMenu() {
        Item it=new Item();
        for(String s:it.hm.keySet()){
            System.out.println(it.hm.get(s).getName()+"->"+it.hm.get(s).getCost());
        }
    }

}
