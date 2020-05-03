import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class loginsignup
{
    static String finalusername;
    static int finalpassword = 0;
    static boolean finallogin = false;
    static ArrayList<String> finalposts = new ArrayList<String>();
    public static void login() throws IOException, FileNotFoundException{
    //get file input and output
    
    FileOutputStream file = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/usernames.txt", true);
    PrintWriter pw = new PrintWriter(file);
    FileInputStream file_read= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/usernames.txt");
    Scanner input = new Scanner(file_read);
    ArrayList<String> existing_usernames = new ArrayList<String>();
  
    //append existing usernames into a list
    
    
    
    while(input.hasNextLine()) {
        String line = input.nextLine();
        existing_usernames.add(line);
    }
    boolean successful_sign_up = true;
    String password_login_check = "";
    System.out.println();
    System.out.println("Welcome to Treddit");
    Scanner choice = new Scanner(System.in);
    System.out.println("Enter '1' to log in or any other number to register for an account");
    int login_or_register = choice.nextInt();
    
    
    if (login_or_register == 1){
    
    ////////////////////////////////////////////////////////////////////////
    //Log into account
    System.out.println("-----------------------------------------------------------------------------------------------------");
    System.out.println("Treddit Login");
    Scanner login = new Scanner(System.in);
    System.out.println("Username: ");
    String username_login = login.next();
    System.out.println("Password: ");
    int password_login = login.nextInt();
    
    //error handling for nonexistent username
    try{
    FileInputStream p= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username_login + ".txt");
    Scanner password_check = new Scanner(p);
    
    //navigate to second line of text file which holds user password
    for(int i = 0; i < 2; i++){
        password_login_check = password_check.nextLine();
    }
    if (password_login_check.equals(String.valueOf(password_login))){
        //Account obj = new Account(username_login, password_login);
        finalusername = username_login;
        finalpassword = password_login;
        int counter = 0;
        finallogin = true;
        
        //loading user posts from textfile
        FileInputStream loadposts= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "Posts.txt");
        Scanner load = new Scanner(loadposts);
    
      while(load.hasNextLine()){
          String load_user_posts = load.nextLine();
          finalposts.add(load_user_posts); 
}
        
     
 
    }
    else{
        System.out.println("Incorrect Username or Password");
    }
}
    catch(FileNotFoundException F){
        System.out.println("Please double check your username");
    }
}
else{
    ////////////////////////////////////////////////////////////////////////
    //registration for account
    System.out.println("-----------------------------------------------------------------------------------------------------");
    System.out.println("Treddit Registration");
    Scanner register = new Scanner(System.in);
    System.out.println("Set Username: ");
    String username = register.next();
    System.out.println("Set Password: ");
    int password = register.nextInt();
    
    //check if username exists already
    for (int i = 0; i < existing_usernames.size(); i++){
        if (existing_usernames.get(i).equals(username)){
            
            successful_sign_up = false;
        }
    }
    if (successful_sign_up == false){
    System.out.println("Incorrect Username or Password");
}
    ////////////////////////////////////////////////////////////////////////
    //creation of new account object with its attributes stored in text file
    if (successful_sign_up){
    System.out.println("Registration Successful!");
    
    pw.write(username);
    pw.println();
    //creating a unique text file labeled with format username.txt
    FileOutputStream new_file = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + ".txt", true);
    PrintWriter pw_unique = new PrintWriter(new_file);
    
    //Writing username and password of new user to newly generated txt
    pw_unique.write(username);
    pw_unique.println();
    pw_unique.write(String.valueOf(password)); //text file only accepts strings
    pw.close();
    pw_unique.close();
    
    //creating a text file to store user posts with format usernamePosts.txt
    FileOutputStream new_file_posts = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Posts.txt", true);
    PrintWriter pw_unique_posts = new PrintWriter(new_file_posts);
    pw_unique_posts.close();
    
    System.out.println();
    System.out.println("Welcome to Treddit");
    Scanner choice1 = new Scanner(System.in);
    

    
   
    
    ////////////////////////////////////////////////////////////////////////
    //Log into account
    System.out.println("-----------------------------------------------------------------------------------------------------");
    System.out.println("Treddit Login");
    Scanner login = new Scanner(System.in);
    System.out.println("Username: ");
    String username_login = login.next();
    System.out.println("Password: ");
    int password_login = login.nextInt();
    
    //error handling for nonexistent username
    try{
    FileInputStream p= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username_login + ".txt");
    Scanner password_check = new Scanner(p);
    
    //navigate to second line of text file which holds user password
    for(int i = 0; i < 2; i++){
        password_login_check = password_check.nextLine();
    }
    if (password_login_check.equals(String.valueOf(password_login))){
        //Account obj = new Account(username_login, password_login);
        finalusername = username_login;
        finalpassword = password_login;
        int counter = 0;
        finallogin = true;
        
        //loading user posts from textfile
        FileInputStream loadposts= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "Posts.txt");
        Scanner load = new Scanner(loadposts);
    
      while(load.hasNextLine()){
          String load_user_posts = load.nextLine();
          finalposts.add(load_user_posts); 
}
        
    FileOutputStream friendfile = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "Friends.txt", true);
    FileOutputStream inbox = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "Inbox.txt", true);
    FileOutputStream declined = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "Declined.txt", true);
    FileOutputStream dms = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + finalusername + "dms.txt", true);
    }
}
    catch(FileNotFoundException F){
        System.out.println("Please double check your username");
    }
}
    }
}

}




