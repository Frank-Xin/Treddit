import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class mainpage
{
    public static void displayMainPage() throws IOException, FileNotFoundException{
          FileInputStream loaddatabase = new FileInputStream("/Users/frank2002/Desktop/IntroJava/hello-copy/postdatabase.txt");
          Scanner loadfromdatabase = new Scanner(loaddatabase);
          ArrayList<String> existing_posts = new ArrayList<String>();
          System.out.println("-------------------------------------------------------------------------------------------------------------------");
          System.out.println("Treddit Main Page");
          System.out.println();
          int counter = 0;
         while(loadfromdatabase.hasNextLine()) {
              String line = loadfromdatabase.nextLine();
              existing_posts.add(line);
              /*counter++;
              if (counter%2 ==0){
                  System.out.println();
                }*/       
              
    } 
    for (int i = existing_posts.size(); i >1; i -=2){
        System.out.println(existing_posts.get(i-2));
        System.out.println(existing_posts.get(i-1));
        System.out.println();
        
    } //append items from postdatabase to main page
    /*
    for (int i = 0; i < existing_posts.size(); i++){
        System.out.println(existing_posts.get(i));
        System.out.println();
        
    }*/

         // System.out.println("-------------------------------------------------------------------------------------------------------------------");
          
        
        
        
        
        
    }
}
