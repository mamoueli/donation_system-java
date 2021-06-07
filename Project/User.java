public abstract class User{
    
    private String userName;
    public String phoneNumber;
    
     public User(String name, String number){
     this.userName=name;
     this.phoneNumber=number;
    }
    
    public void setName(String name){this.userName=name;}
    public void setNumber(String number){this.phoneNumber=number;}
    public String getUserName(){return userName;}
    public String getPhoneNumber(){return phoneNumber;}
    
    
    
}