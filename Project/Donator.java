import java.util.ArrayList;
import java.util.List;

public class Donator extends User{
 
    ArrayList<Offers>offersList = new ArrayList<Offers>();
    
    public Donator(String name, String number){
     super(name, number);
    }
    public void addOffer(Offers offer){offersList.add(offer);}
    public void removeOffer(Offers offer){offersList.remove(offer);}
    
    public void listOffers()
    {
         for(int i = 0; i < this.offersList.size(); i++)
                    {
                        System.out.println("Offer " + i +" : " + offersList.get(i)); 
                    }
    }
}