import java.util.ArrayList;
import java.util.List;

public class RequestDonationList{
 
    ArrayList<RequestDonation>rdEntities = new ArrayList<RequestDonation>();
    
    public RequestDonationList(){} //default constructor
    
    public RequestDonation get(int Id){
        return rdEntities.get(Id);
    }
    public void addRequestDonation(RequestDonation rd){
     rdEntities.add(rd);   
    }
    public void removeRequestDonation(RequestDonation rd){
     rdEntities.remove(rd);   
    }
    public void resetRequestDonation(){
     rdEntities.clear();   
    }
    public RequestDonation getRd(int i){
     return rdEntities.get(i);
    }
      
}