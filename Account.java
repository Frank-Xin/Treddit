import java.util.ArrayList;
public class Account
{
    String name;
    int password;
    ArrayList<String> posts = new ArrayList<String>();
   
    
        public Account(String name, int password){
        this.name = name;
        this.password = password;
    }
    
        public Account(String name, int password, ArrayList<String> posts){
        this.name = name;
        this.password = password;
        this.posts = posts;
        
    }
    public static void main(){
        System.out.println("hi");


    
}
   public void post(String content){
       posts.add(content);

    }
    
}
