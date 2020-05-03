import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class personalpage
{
    static Account current_user = new Account(loginsignup.finalusername,loginsignup.finalpassword,loginsignup.finalposts);
    public static void setup() throws IOException, FileNotFoundException
    {
        
        loginsignup.login();
        current_user.name = loginsignup.finalusername;
        current_user.password = loginsignup.finalpassword;
        current_user.posts = loginsignup.finalposts;

        if (loginsignup.finallogin){
        System.out.println("Login Successful");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome back, " + current_user.name);
        System.out.println();
    }
}
    public static void viewposts(){
       /* System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to view your past posts");
        System.out.println("Press 2 to post something to the main page");
        System.out.println("Press 3 to exit");
        int choice = post.nextInt();*/
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Your posts:");
        for (int i = 0; i < current_user.posts.size(); i++){
            System.out.println(current_user.posts.get(i));
            
            if (current_user.posts.get(i).equals("Posted by" + current_user.name)){
                System.out.println();
            }
        
    }
}
    public static void postapost() throws IOException, FileNotFoundException{
        
        System.out.println("Post something");
        Scanner obj = new Scanner(System.in);
        String user_post = obj.nextLine();
        if (user_post.length() <=140){
 
        user_post += "\n" + "Posted by " + current_user.name;
          FileOutputStream new_file_posts = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + current_user.name + "Posts.txt", true);
          PrintWriter pw_unique_posts = new PrintWriter(new_file_posts);
          current_user.post(user_post);
          pw_unique_posts.write(user_post);
          pw_unique_posts.println();
          pw_unique_posts.close();
          FileOutputStream postdatabase = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/postdatabase.txt", true);
          PrintWriter pw_postdatabase = new PrintWriter(postdatabase);
          pw_postdatabase.write(user_post);
          pw_postdatabase.println();
          pw_postdatabase.close();
          System.out.println("Posted to Treddit Main Page!");
    }
    }

    
        
        
       
    }
        
        
    
