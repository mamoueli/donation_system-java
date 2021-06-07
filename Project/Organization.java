import java.util.ArrayList;
public class Organization {
    
    int i=1;
    private String name;
    private Admin admin;
    ArrayList<Entity>entityList = new ArrayList<Entity>();
    ArrayList<Donator>donatorList = new ArrayList<Donator>();
    ArrayList<Beneficiary>beneficiaryList = new ArrayList<Beneficiary>();
    ArrayList<RequestDonationList>currentDonations = new ArrayList<RequestDonationList>(); 
    
    public Organization(String name, Admin admin){
        this.name=name;
        this.admin=admin;
    }
    public Organization(){}
    public String getOrg(){return name;}
    public void setAdmin(Admin admin) {this.admin=admin;}
    public Admin getAdmin(){return admin;}
    public void addEntity(Entity entity){entityList.add(entity);}
    public void removeEntity(Entity entity){entityList.remove(entity);}
    public void insertDonator(Donator donator) {donatorList.add(donator);}
    public void removeDonator(Donator donator) {donatorList.remove(donator);}
    public void insertBeneficiary(Beneficiary beneficiary) {beneficiaryList.add(beneficiary);}
    public void removeBeneficiary(Beneficiary beneficiary) {beneficiaryList.remove(beneficiary);}
    public void listDonators()
    {
        for(Donator donator:donatorList)
        {
         System.out.println("Donator " + i++ + " :" + donator.getUserName());
        }
        i=1;
    }
    public ArrayList<Donator> getDonators()
    {
        return donatorList;
    }
    public void listEntities()
    {
        for(Entity entity:entityList)
        {
         System.out.println("Entity " + i++ + ":"  + entity.getEntityInfo());
        }
        i=1;
    }
    public ArrayList<Entity> getEntities()
    {
        return entityList;
        
    }    
    public void listBeneficiaries()
    {
        for(Beneficiary beneficiary:beneficiaryList)
        {
         System.out.println("Beneficiary " + i++ + " :" + beneficiary.getUserName());
        }
        i=1;
    }
     public ArrayList<Beneficiary> getBeneficiaries()
    {
        return beneficiaryList;
    }
 
}