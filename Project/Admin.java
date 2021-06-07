public class Admin extends User{
    
    public boolean isAdmin=true;
    
    public Admin(String name, String number){
     super(name, number);   
     this.isAdmin=isAdmin;
    }
     
}