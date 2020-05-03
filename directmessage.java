import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class directmessage
{
    public static void viewdms(String user) throws IOException{
        FileInputStream dms= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + user + "dms.txt");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Your messages:");
        Scanner readdms = new Scanner(dms);
        while (readdms.hasNextLine()){
            String line = readdms.nextLine();
            System.out.println(line);
        }
    }
    
    public static void senddm(String user) throws IOException{
        boolean isfriend = false;
        Scanner obj = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose a friend to send a message to");
        ArrayList<String> friends = new ArrayList<String>();
        FileInputStream friends1= new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + user + "Friends.txt");
        Scanner reader = new Scanner(friends1);
        System.out.println("Your list of friends:");
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            friends.add(line);
            System.out.println(line);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        String directed = obj.nextLine();
        for(int i =0; i< friends.size(); i++){
            if (friends.get(i).equals(directed)){
                isfriend = true;
                
            }
        }
        if (isfriend){
        System.out.println("Type a message");
        String message = obj.nextLine();
        
        FileOutputStream write= new FileOutputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/" + directed + "dms.txt");
        PrintWriter write1 = new PrintWriter(write);
        write1.write(message + "\n" + "Sent by " + user);
        write1.println();
        write1.close();
        System.out.println("Message sent to " + directed);
        
    }
    else{
        System.out.println("You can only direct message a friend");
    }
    }
}
