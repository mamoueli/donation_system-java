public class Main{
    public static void main(String[] args){
        
        Admin yesAdmin = new Admin("Spooner Oldham", "111");
        Organization yes = new Organization("Yes",yesAdmin);
        Menu menu1 = new Menu();
        
        Beneficiary b1 = new Beneficiary("Ben Gazzara", "222", 4);
        Beneficiary b2 = new Beneficiary("Noelle Kao", "333", 2);
        
        Donator don = new Donator("Donny Freckles", "444");
        
        Material dairy = new Material("Milk", "dairy products", 2, 2, 4, 6);
        Material infantFormula = new Material("Infant Formula", "baby food", 3, 0, 1, 3);
        Material clothes = new Material("Clothes", "Jackets and Winterwear", 4, 1, 4, 6);
        
        Service nursing = new Service("Nursing", "medical assistance", 1);
        Service doctors = new Service("Doctor Examination", "medical assistance", 1);
        Service babysitting = new Service("Babysitting", "child support", 3);
        
        yes.insertDonator(don); yes.insertBeneficiary(b1);
        yes.insertBeneficiary(b2); yes.setAdmin(yesAdmin);
        yes.addEntity(dairy); yes.addEntity(clothes); yes.addEntity(infantFormula);
        yes.addEntity(nursing); yes.addEntity(doctors); yes.addEntity(babysitting);
        
        RequestDonation ai=new RequestDonation(dairy, 5);
        RequestDonationList rdl = new RequestDonationList(); 
       
        menu1.loginMenu(yes); 
         
        }
    }