import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        intro();
        Scanner sc=new Scanner(System.in);
        RegistrationAndLogin rl=new RegistrationAndLogin();
        while(true){
            try{
                System.out.println("Type 1 : Registration");
                System.out.println("Type 2 : Login");
                System.out.println("Type 3 : Exit");
                System.out.println("Enter your choice");
                int user_choice=sc.nextInt();
                if (user_choice == 1) {
                    rl.registration();
                }
                if (user_choice == 2) {
                    rl.login();
                }
                if (user_choice == 3) {
                    break;
                }
                if(user_choice<1 || user_choice>3){
                    System.out.println("Invalid Choice Please Enter a valid choice(1/2/3)");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Choice Please Enter a valid choice(1/2/3)");
                sc.next();
            }
        }
    }
    public static void intro(){
        System.out.println("Welcome");
    }
}