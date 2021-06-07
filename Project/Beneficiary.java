import java.util.ArrayList;
public class Beneficiary extends User{
    int i=1;
    private int noPersons=1;
    ArrayList<RequestDonationList>receivedList = new ArrayList<RequestDonationList>();
    ArrayList<Requests>requestsList = new ArrayList<Requests>();
    
    public Beneficiary(String name, String number, int noPersons){
    super(name, number);
    this.noPersons=noPersons;
   }
   public void addRequest(Requests request){requestsList.add(request);}
   public void removeRequest(Requests request){requestsList.remove(request);}
   public void addReceived(RequestDonationList received){receivedList.add(received);}
   public void removeReceived(RequestDonationList received){receivedList.remove(received);}
   public void listReceived()
    {
        for(int i = 0; i < this.receivedList.size(); i++)
        {
         System.out.println("Received" + i++ + ":" + receivedList.get(i));
         
        }
        i=1;
    }
}
