import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        intro();
        Scanner sc=new Scanner(System.in);
        HomePage hm=new HomePage();
        while(true){
            try{
                System.out.println("Type 1 : Registration");
                System.out.println("Type 2 : Login");
                System.out.println("Type 3 : Exit");
                System.out.println("Enter your choice");
                int user_choice=sc.nextInt();
                if (user_choice == 1) {
                    hm.registration();
                }
                if (user_choice == 2) {
                    hm.login();
                }
                if (user_choice == 3) {
                    break;
                }
                if(user_choice<1 || user_choice>3){
                    System.out.println("Invalid Choice Please Enter a valid choice(1/2/3)");
                }
            }
            catch (InputMismatchException e){
                System.out.println(e);
            }
        }
    }
    public static void intro(){
        System.out.println("Welcome");
    }
}