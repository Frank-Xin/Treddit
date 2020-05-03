import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class socialmedia
{
    public static void main() throws IOException, FileNotFoundException{
        personalpage.setup();
        if (loginsignup.finallogin){
        while (true){
        Scanner post = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to view your past posts");
        System.out.println("Press 2 to post something to the main page");
        System.out.println("Press 3 to view your friends");
        System.out.println("Press 4 to add a friend");
        System.out.println("Press 5 to check your friend request inbox");
        System.out.println("Press 6 to direct Message a Friend");
        System.out.println("Press 7 to check your messages");
        System.out.println("Press 8 to go to Treddit Main Page");
        System.out.println("Press 9 to exit");
        
        int choice = post.nextInt();
        if (choice == 1){
            personalpage.viewposts();
        }
        else if (choice == 2){
            personalpage.postapost();
        }
        else if (choice == 3){
            friendinbox.viewfriends(loginsignup.finalusername);
        }
        else if (choice == 4){
            friendinbox.requestfriend(loginsignup.finalusername);
        }
         else if (choice == 5){
            friendinbox.checkinbox(loginsignup.finalusername);
        }
        else if (choice == 6){
            directmessage.senddm(loginsignup.finalusername);
        }
        else if (choice == 7){
            directmessage.viewdms(loginsignup.finalusername);
        }
        else if (choice == 8){
            mainpage.displayMainPage();
        }
        
        else{
            break;
        }
    }
        
        
    }
    }
        
    }

