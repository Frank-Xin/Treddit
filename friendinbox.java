import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class friendinbox
{
    static ArrayList<String> friends = new ArrayList<String>();
    static ArrayList<String> existingusernames = new ArrayList<String>();
    static ArrayList<String> declinedusers = new ArrayList<String>();
    public static void viewfriends(String username)throws IOException, FileNotFoundException{ //works
        System.out.println("------------------------------------------------------------------------------------------------");
        FileInputStream friend = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Friends.txt");
        Scanner friendinboxread = new Scanner(friend);
        System.out.println("Friend List:");
        //reading friend file
        while(friendinboxread.hasNextLine()){
            String line = friendinboxread.nextLine();
            System.out.println(line);
        }
    }
    public static void requestfriend(String username)throws IOException, FileNotFoundException{ //this method works but needs to check if the username exists or not, check from the username database
    
        FileInputStream checkuser = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/usernames.txt");
        Scanner check = new Scanner(checkuser);
        //check for existing users
        while (check.hasNextLine()){
            String line = check.nextLine();
            existingusernames.add(line); 
        }
        boolean repeat = false;
        boolean alreadyfriend = false;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Add Friend: ");
        Scanner addfriend = new Scanner(System.in);
        System.out.println("Enter the username of the friend you want to add: ");
        String friend = addfriend.nextLine();
        for(int i = 0; i < existingusernames.size(); i++){
            if (existingusernames.get(i).equals(friend)){
                repeat = true; //repeat = true meaning user does exist
            }
        }
        FileInputStream checkfriend = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Friends.txt");
        Scanner check1 = new Scanner(checkfriend);
        while (check1.hasNextLine()){
            String line = check1.nextLine();
            if (line.equals(friend)){
                alreadyfriend = true; //already friends
                
            }
        }
        if (repeat && !alreadyfriend){
        FileOutputStream directmessage = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/"+ friend + "Inbox.txt", true);
        PrintWriter pwdirect = new PrintWriter(directmessage);
        pwdirect.write(username + " has requested to be your friend!");
        pwdirect.println();
        pwdirect.close();
        System.out.println("You have requested to add " + friend + " as a friend");
    }
    else{
        if (repeat == false){

        System.out.println("The username does not exist");
    }
    if (alreadyfriend){
        System.out.println(friend + " is already your friend");
    }
    
}
}


    public static void checkinbox(String username)throws IOException, FileNotFoundException{
        FileInputStream inbox = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Inbox.txt");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Inbox: ");
        FileInputStream friendcheck = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Friends.txt");
        Scanner readfriend = new Scanner(friendcheck);
        while(readfriend.hasNextLine()){
            String line = readfriend.nextLine();
            friends.add(line);
            
            
        }
        FileInputStream declinedcheck = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Declined.txt");
        Scanner declined = new Scanner(declinedcheck);
        while(readfriend.hasNextLine()){
            String line = declined.nextLine();
            declinedusers.add(line);
        }
        
        
        
       
        Scanner inboxread = new Scanner(inbox); //find method to delete the messages after accepting or declining also posts are not showing up
        while (inboxread.hasNextLine()){
             boolean norepeat = true;
             boolean nodeclinedrepeat = true;
             
            Scanner accept = new Scanner(System.in);
            String userrequest = inboxread.nextLine();
            String specificuser = userrequest.substring(0, userrequest.indexOf(' ')); //get first word which is the user that requested
        for (int i = 0; i < friends.size(); i++){
                if (friends.get(i).equals(specificuser)){
                    norepeat = false;
                }
            }
        for (int i = 0; i < declinedusers.size(); i++){
                if (declinedusers.get(i).equals(specificuser)){
                    nodeclinedrepeat = false;
                }
            }
            if (norepeat && nodeclinedrepeat){
            System.out.println(userrequest);
            System.out.println("Press 1 to accept or any other number to decline");
            int acception = accept.nextInt();

            if (acception == 1){
                
                FileOutputStream  accepteduser = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Friends.txt", true);
                PrintWriter accepted = new PrintWriter(accepteduser);
                System.out.println(specificuser + " has become your friend!");
                accepted.write(specificuser);
                accepted.println();
                accepted.close();
                //adding the current user as a friend to the user that requested
                FileOutputStream  specific = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + specificuser + "Friends.txt", true);
                PrintWriter s = new PrintWriter(specific);
                s.write(username);
                s.println();
                s.close();
                
            }
            else{
                System.out.println("You have declined " + specificuser);
                FileOutputStream declinedadd = new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + username + "Declined.txt", true);
                PrintWriter d = new PrintWriter(declinedadd);
                d.write(specificuser);
                d.println();
                d.close();
                declinedusers.add(specificuser);
                
        }
        }
    
    }
        
}
    }
