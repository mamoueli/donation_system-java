import java.util.Scanner;   
import java.util.ArrayList;

public class Menu 
{ 
   Organization org = new Organization();
   ArrayList<Entity>materialsList = new ArrayList<Entity>();
   ArrayList<Entity>servicesList = new ArrayList<Entity>();
    
    // MAIN MENU
   public void welcomeMenu()
   {
    System.out.println("============----------------============\n"
    +                  "            Welcome to the              \n"
    +                  "            Donation System             \n"
    +                  "============----------------============\n");
    
    }
   public void loginMenu(Organization org)
    {   
        welcomeMenu();
        this.org = org;
        int i = 0;
        Scanner scanner = new Scanner(System.in); 
        String phNum;
        ArrayList<String> donatorListPh = new ArrayList(); //λίστα με τηλέφωνα των beneficiaries
        ArrayList<String> beneficiaryListPh = new ArrayList(); //λίστα με τηλέφωνα των donators

        // συλλέγει τα τηλέφωνα των beneficiaries/donators για την ταυτοποίηση 
        for(i = 0; i < org.getDonators().size(); i++)
            {
                donatorListPh.add(org.getDonators().get(i).getPhoneNumber());
            }
        for(i = 0; i < org.getBeneficiaries().size(); i++)
            {
                beneficiaryListPh.add(org.getBeneficiaries().get(i).getPhoneNumber());
            }
       
        // προσδιορίζει αν ο user είναι beneficiary || donator || admin
        System.out.println("\nPlease enter your phone number: ");
        phNum = scanner.nextLine(); 

        if(org.getAdmin() != null && phNum.equals(org.getAdmin().getPhoneNumber()))
        {
            adminMenu(org.getAdmin());
        }
        else if(donatorListPh.contains(phNum))
        {
            for(i = 0; i < org.getDonators().size(); i++)
            {
                if(org.getDonators().get(i).getPhoneNumber().equals(phNum))
                {
                    donatorMenu(org.getDonators().get(i));
                }
            }
        }
        else if(beneficiaryListPh.contains(phNum))
        {
            for(i = 0; i < org.getBeneficiaries().size(); i++)
            {
                if(org.getBeneficiaries().get(i).getPhoneNumber().equals(phNum))
                {
                    beneficiaryMenu(org.getBeneficiaries().get(i));
                }
            }
        }
        else
        {   //αν δεν υπάρχει ήδη αυτός ο χρήστης εμφανίζεται επιλογή εγγραφής(registrationMenu)
            System.out.println("\nNo user found " 
                            + "\nWould you like to register? (Y/N)\n");
            String userIn = scanner.nextLine();
            
            if(userIn.equals("Y") || userIn.equals("y"))
            {
                registrationMenu();
            }
            else if(userIn.equals("N") || userIn.equals("n"))
            {
                System.out.println("Thank you for using our application!");
                System.exit(0);
            }
        }

    }
// DONATOR MENU
   public void donatorMenu(Donator donator)
   {   
         int i = 0;
         Scanner scanner = new Scanner(System.in);
        
         System.out.println("             DONATOR MENU             "
                       +   "\n===================================="
                       +   "\nName:"        +  donator.getUserName()
                       +   "\nNumber:"      +  donator.getPhoneNumber()
                       +   "\nOrganization:"+  org.getOrg() 
                       +   "\n\n            Donator                "
                       +    "\n==================================="
                       +    "\n            OPTIONS                "
                       +    "\n==================================="
                       +    "\n1)Add Offer "
                       +    "\n2)Show Offers"
                       +    "\n3)Commit "
                       +    "\n4)Back"
                       +    "\n5)Logout"
                       +    "\n6)Exit the application\n");
            
         int choice = scanner.nextInt();
           
         switch(choice)
            {           
                case 1:
                Scanner dOption = new Scanner(System.in);
                System.out.println("Pick Entity:"
                              +"\n 1. Material  "
                              +"\n 2. Services  "
                              +"\n 3. Back     \n ");
                              
                int userChoice = dOption.nextInt();
                
                if(userChoice==1)
                {//αν επιλεγεί το materials, προσκόμηση των materials στον materialsList 
                 for(i = 0; i < org.getEntities().size(); i++)
                    {
                        if(org.getEntities().get(i).getClass().getSimpleName().equals("Material")) //if class name like "Material", προσκόμηση στη λίστα
                        {
                          materialsList.add(org.entityList.get(i));
                        }
                    }
                  int j=1;
                  for(Entity entity:materialsList)  //εκτύπωση materials
                     {
                      System.out.println("Material " + j++ + ":" + entity.getDetails());
                     }
                     
                  System.out.println("\nWould you like to donate ? (Y/N)");
                  Scanner dOption2 = new Scanner(System.in);
                  String userChoice2 = dOption2.nextLine();
                  
                  if(userChoice2.equals("Y") || userChoice2.equals("y"))
                  {
                      Scanner item = new Scanner(System.in);
                      System.out.println("Which item would you like to offer: ");
                      int itemChoice = item.nextInt();
                      System.out.println("How many " + materialsList.get(itemChoice-1).getName() + " would you like to offer: ");
                      int itemChoiceQuantity = item.nextInt();
                      
                     /*add offer - δεν βρήκαμε πως τα requestDonation στοιχεία που προσκομίσαμε(Entity, quantity),
                       να τα μετατρέψουμε σε αντικείμενο offer ώστε να μπουν στο offerList του donator(Entity=materialsList.get(itemChoice-1), quantity=itemChoiceQuantity) */
                     Offers offer = new Offers();
                     donator.addOffer(offer);
                     continueUsingAppDonator(donator);
                  }
                   else if(userChoice2.equals("N") || userChoice2.equals("n")){
                   donatorMenu(donator);
                  }
                
                 }
                else if(userChoice==2)
                { //αν επιλεγεί το services, προσκόμηση των services στον servicesList 
                 for(i = 0; i < org.getEntities().size(); i++)
                    {
                        if(org.getEntities().get(i).getClass().getSimpleName().equals("Service"))//if class name like "Material", προσκόμηση στη λίστα
                        {
                          servicesList.add(org.entityList.get(i));
                        }
                    }
                 int j=1;
                 for(Entity entity:servicesList) //εκτύπωση services
                     {
                      System.out.println("Service " + j++ + ":" + entity.getDetails());
                     }
                     
                 System.out.println("\n\nWould you like to donate ? (Y/N)");
                 Scanner c2 = new Scanner(System.in);
                 String userChoice2 = c2.nextLine();
                 
                 if(userChoice2.equals("Y") || userChoice2.equals("y"))
                 {
                   Scanner item = new Scanner(System.in);
                   System.out.println("Which service would you like to offer: ");
                   int itemChoice = item.nextInt();
                   System.out.println("How many hours of " + servicesList.get(itemChoice-1).getName() + " would you like to offer: ");
                   itemChoice = item.nextInt();
                   //add offer - ιδιο πρόβλημα με την add offer για materials
                   Offers offer = new Offers();
                   donator.addOffer(offer);
                   continueUsingAppDonator(donator);
                 }
                 else if(userChoice2.equals("N") || userChoice2.equals("n")){
                   donatorMenu(donator);
                  } 
                }
                else if(userChoice==3){
                      donatorMenu(donator);
                    }
                  
                case 2:
                //Λόγω του αναφερθέντος μπερδέματος με τις requestDonationList-offers/requests δεν καταφέραμε να υλοποιήσουμε αυτή την επιλογή  
                donatorMenu(donator);  
                  
                  
                case 3:
                 donatorMenu(donator);   
                  
                case 4:
                loginMenu(org); //πίσω
                  
                case 5:
                loginMenu(org); //η ροή επιστρέφει στο loginMenu
                  
                case 6:
                  System.out.println("Thank you for using our application");
                  System.exit(0); //έξοδος
                 
                default:  
                //σε περίπτωση που δεν επιλεχθεί 1||2||3||4||5||6
                System.out.println("\nInvalid input, please try again");
                donatorMenu(donator);  
             
         }         
    }
    // BENEFICIARY MENU
   public void beneficiaryMenu(Beneficiary beneficiary)
   {   int i = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("            BENEFICIARY MENU         "
                       +   "\n===================================="
                       +   "\nName:"        +  beneficiary.getUserName()
                       +   "\nNumber:"      +  beneficiary.getPhoneNumber()
                       +   "\nOrganization:"+  org.getOrg() 
                       +    "\n           Beneficiary                "
                       +    "\n==================================="
                       +    "\n            OPTIONS                "
                       +    "\n==================================="
                       +    "\n1)Add Request "
                       +    "\n2)Show Requests"
                       +    "\n3)Commit "
                       +    "\n4)Back"
                       +    "\n5)Logout"
                       +    "\n6)Exit the application \n");
            
        int choice = scanner.nextInt();
           
        switch(choice)
            {           
                  case 1:
                Scanner dOption = new Scanner(System.in);
                System.out.println("Pick Entity:"
                              +"\n 1. Material  "
                              +"\n 2. Services  "
                              +"\n 3. Back      ");
                int userChoice = dOption.nextInt();
                if(userChoice==1)
                {  //αν επιλεγεί το materials, προσκόμηση των materials στον materialsList 
                  for(i = 0; i < org.getEntities().size(); i++)
                    {
                        if(org.getEntities().get(i).getClass().getSimpleName().equals("Material")) //if class name like "Material", προσκόμηση στη λίστα
                        {
                          materialsList.add(org.entityList.get(i));
                        }
                    }
                  int j=1;
                  for(Entity entity:materialsList)  //εκτύπωση materials
                     {
                      System.out.println("Material " + j++ + ":" + entity.getDetails());
                     }
                     
                  System.out.println("\n\nWould you like to request a donation ? (Y/N)");
                  Scanner dOption2 = new Scanner(System.in);
                  String userChoice2 = dOption2.nextLine();
                  
                  if(userChoice2.equals("Y") || userChoice2.equals("y"))
                  {
                      Scanner item = new Scanner(System.in);
                      System.out.println("Which item would you like to request: ");
                      int itemChoice = item.nextInt();
                      System.out.println("How many " + materialsList.get(itemChoice-1).getName() + " would you like to get: ");
                      itemChoice = item.nextInt();
                      
                     /*add requset - δεν βρήκαμε πως τα requestDonation στοιχεία που προσκομίσαμε(Entity, quantity),
                       να τα μετατρέψουμε σε αντικείμενο request ώστε να μπουν στο requestsList του beneficiary */
                     Requests request = new Requests();
                     beneficiary.addRequest(request);
                     continueUsingAppBeneficiary(beneficiary);
                  }
                   else if(userChoice2.equals("N") || userChoice2.equals("n")){
                   beneficiaryMenu(beneficiary);
                  }
                
                }
                else if(userChoice==2)
                { //αν επιλεγεί το services, προσκόμηση των services στον servicesList 
                 for(i = 0; i < org.getEntities().size(); i++)
                    {
                        if(org.getEntities().get(i).getClass().getSimpleName().equals("Service"))//if class name like "Material", προσκόμηση στη λίστα
                        {
                          servicesList.add(org.entityList.get(i));
                        }
                    }
                 int j=1;
                 for(Entity entity:servicesList) //εκτύπωση services
                     {
                      System.out.println("Service " + j++ + ":" + entity.getDetails());
                     }
                     
                 System.out.println("\n\nWould you like to request a donation ? (Y/N)");
                 Scanner c2 = new Scanner(System.in);
                 String userChoice2 = c2.nextLine();
                 
                 if(userChoice2.equals("Y") || userChoice2.equals("y")){
                   Scanner item = new Scanner(System.in);
                   System.out.println("Which service would you like to request: ");
                   int itemChoice = item.nextInt();
                   System.out.println("How many hours of " + servicesList.get(itemChoice-1).getName() + " would you like to get: ");
                   itemChoice = item.nextInt();
                   //add requset - ίδιο πρόβλημα με παραπάνω 
                   Requests request = new Requests();
                   beneficiary.addRequest(request);
                   continueUsingAppBeneficiary(beneficiary);
                  }
                   else if(userChoice2.equals("N") || userChoice2.equals("n")){
                   beneficiaryMenu(beneficiary);
                  } 
                 }
                else if(userChoice==3){
                    beneficiaryMenu(beneficiary);
                    }
                  case 2:
                  //Λόγω του αναφερθέντος μπερδέματος με τις requestDonationList-offers/requests δεν καταφέραμε να υλοποιήσουμε αυτή την επιλογή 
                  beneficiaryMenu(beneficiary);
                  
                  
                  case 3:
                  beneficiaryMenu(beneficiary);
                  
                  case 4:
                  loginMenu(org); //πίσω
                  
                  case 5:
                  loginMenu(org); //ροή επιστρέφει στο loginMenu
                  
                  case 6:
                  System.out.println("Thank you for using our application");
                  System.exit(0); //έξοδος
                  
                  default:
                  //σε περίπτωση που δεν επιλεχθεί 1||2||3||4||5||6
                  System.out.println("\nInvalid input, please try again");
                  beneficiaryMenu(beneficiary);
                }
                   
   }
    
    
    // ADMIN MENU
   public void adminMenu(Admin admin)
   {   int i = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(  "\n            ADMIN MENU              "
                        +    "\n==================================="
                        +    "\nName: " + admin.getUserName()
                        +    "\nNumber: " + admin.getPhoneNumber()
                        +    "\n              Admin                "
                        +    "\n==================================="
                        +    "\n            OPTIONS                "
                        +    "\n==================================="
                        +    "\n1)View "
                        +    "\n2)Monitor Organization Info"
                        +    "\n3)Back"
                        +    "\n4)Logout"
                        +    "\n5)Exit the application \n");
            
        int choice = scanner.nextInt();

        switch(choice)
        {
                case 1:
              System.out.println("===================================\n"
                           +    "         ENTITY CATEGORIES          \n"
                           +    " ===================================\n"); 
              for(i = 0; i < org.getEntities().size(); i++)
                  {
                     if(org.getEntities().get(i).getClass().getSimpleName().equals("Material")) //if class name like "Material", προσκόμηση στη λίστα
                     {
                       materialsList.add(org.entityList.get(i));
                     }
                  }
              System.out.println("\n1) Materials   " + "(" + materialsList.size() + ")");
              for(i = 0; i < org.getEntities().size(); i++)
                  {
                     if(org.getEntities().get(i).getClass().getSimpleName().equals("Service")) //if class name like "Service", προσκόμηση στη λίστα
                     {
                       servicesList.add(org.entityList.get(i));
                     }
                   }
                   
              System.out.println("\n2) Services   " + "(" + servicesList.size() + ")");
              Scanner aOption0 = new Scanner(System.in);
              System.out.println("\nPick Entity:"
                              +"\n 1. Material  "
                              +"\n 2. Services  "
                              +"\n 3. Back      ");
                              
              int userChoice = aOption0.nextInt();
              Scanner aOption1 = new Scanner(System.in);//μετέπειτα, για επιλογή εκτύπωσης πληροφοριών κάποιου Entity(ορατότητα και σε if και σε else)
              
            if(userChoice==1)
            {  //αν επιλεγεί το materials, εκτύπωση των materials του materialsList 
                 int j=1;
                 for(Entity entity:materialsList)  
                     {
                      System.out.println("Material " + j++ + ":" + entity.getName());
                     }
                 System.out.println("\nChoose between Materials 1 - " + materialsList.size() + " to view further info :");
                 try
                 {//εκτύπωση των πληροφοριών του ζητούμενου Material και χειρισμός εξαίρεσης (εαν επιλεγεί στοιχείο που δεν υπάρχει στη λίστα)
                      userChoice = aOption1.nextInt();
                      System.out.println(materialsList.get(userChoice-1));
                 }
                 catch(Exception e){
                    System.out.println("Invalid input\n");
                    }
             }
            else if(userChoice==2)
            {  //αν επιλεγεί το services, εκτύπωση των services του servicesList 
                int j=0;
                for(Entity entity:servicesList)  
                   {
                    System.out.println("Service " + j++ + ":" + entity.getName());
                   }
                System.out.println("\nChoose between Services 1 - " + servicesList.size() + " to view further info :");
                try
                {//εκτύπωση των πληροφοριών του ζητούμενου Service και χειρισμός εξαίρεσης (εαν επιλεγεί στοιχείο που δεν υπάρχει στη λίστα)
                  userChoice = aOption1.nextInt();
                   System.out.println(servicesList.get(userChoice-1) + "\n");
                }
                catch(Exception e){
                 System.out.println("Invalid input\n");
                }
            }
             else if(userChoice==3){
                adminMenu(admin);   
              }
            
            continueUsingAppAdmin(admin); //εμφάνιση μηνύματος εαν ο χρήστης θέλει να συνεχίσει, για να μην σταματήσει απότομα η εφαρμογή
        
                case 2:
            System.out.println("Choose Action:  "
                              +"\n 1. List Beneficiaries  "
                              +"\n 2. List Donators     "
                              +"\n 3. Reset Beneficiaries Lists"
                              +"\n 4. Back     \n ");
            
            int choice2 = scanner.nextInt();
            switch(choice2)
            {
            case 1:
            
            System.out.println("=======================================\n"
                            +  "            Beneficiaries            \n"
                            +  "=======================================\n"); 
                            
            org.listBeneficiaries();
            System.out.println("\nChoose a beneficiary: ");
            Scanner ben = new Scanner(System.in);
            int cb = ben.nextInt();
            
            org.beneficiaryList.get(cb-1).listReceived();  //doesnt work properly
            
            System.out.println("Would you like to clear the list ? (Y/N)\n");
            Scanner aOption = new Scanner(System.in);
            String userChoice2 = aOption.nextLine();
            
            if(userChoice2.equals("Y") || userChoice2.equals("y")){
             org.beneficiaryList.get(cb-1).receivedList.clear();
             System.out.println("Successfully cleared list!\n");}
            else if(userChoice2.equals("N") || userChoice2.equals("n")){break;}
            
            System.out.println("Would you like to delete current Beneficiary? (Y/N)\n");
            Scanner aOption2 = new Scanner(System.in);
            String userChoice3 = aOption2.nextLine();
            
            if(userChoice3.equals("Y") || userChoice3.equals("y"))
            {
             org.removeBeneficiary(org.beneficiaryList.get(cb-1));
             System.out.println("Successfully removed beneficiary!\n");
            }
            else if(userChoice3.equals("N") || userChoice3.equals("n"))
            {
             break;
            }  
            continueUsingAppAdmin(admin);
            
            case 2:
            
            System.out.println("=======================================\n"
                            +  "              Donators                \n"
                            +  "=======================================\n"); 
                            
            org.listDonators();
            System.out.println("\nChoose a donator: ");
            Scanner don = new Scanner(System.in);
            int cd = don.nextInt();
            
            org.donatorList.get(cd-1).listOffers(); //doesnt work properly
            
            System.out.println("Would you like to delete current Donator? (Y/N)\n");
            Scanner aOption3 = new Scanner(System.in);
            userChoice3 = aOption3.nextLine();
            
            if(userChoice3.equals("Y") || userChoice3.equals("y"))
            {
             org.removeDonator(org.donatorList.get(cd-1));
             System.out.println("Successfully removed donator!\n");
            }
            else if(userChoice3.equals("N") || userChoice3.equals("n"))
            {
             break;
            }  
            continueUsingAppAdmin(admin);
            
            case 3:
            
            for(i=0 ; i<org.beneficiaryList.size(); i++)
            { org.beneficiaryList.get(i).receivedList.clear();  
            }
            System.out.println("Successfully cleared all lists!\n");
            
            continueUsingAppAdmin(admin);
            
            case 4:
            
            adminMenu(admin);
            }
            
                case 3: 
                adminMenu(admin);
                case 4:
                loginMenu(org); //ροή επιστρέφει στο loginMenu
                case 5:
                System.out.println("Thank you for using the application!");
                System.exit(0); //έξοδος
                
                default:
                //σε περίπτωση που δεν επιλεχθεί 1||2||3|4||5
                System.out.println("\nInvalid input, please try again");
                adminMenu(admin); 
            }
       // }while(neverEnd);

    }
    //εμφανίζεται μόλις ολοκληρωθεί μια διεργασία για να μην τελειώνει απότομα το πρόγραμμα
    public void continueUsingAppAdmin(Admin admin)
    {
          System.out.println("Would you like to continue using the application ? (Y/N)\n ");
            Scanner y = new Scanner(System.in);
            String userIn = y.nextLine();
          if(userIn.equals("Y") || userIn.equals("y"))
          {
                adminMenu(admin);
          }
          else if(userIn.equals("N") || userIn.equals("n"))
          {
                System.out.println("\nThank you for using the application!");
                System.exit(0);
          }
    }
    public void continueUsingAppDonator(Donator donator)
    {
          System.out.println("Would you like to continue using the application ? (Y/N)\n ");
            Scanner y = new Scanner(System.in);
            String userIn = y.nextLine();
          if(userIn.equals("Y") || userIn.equals("y"))
          {
                donatorMenu(donator);
          }
          else if(userIn.equals("N") || userIn.equals("n"))
          {
                System.out.println("\nThank you for using the application!");
                System.exit(0);
          }
    }
    public void continueUsingAppBeneficiary(Beneficiary beneficiary)
    {
          System.out.println("Would you like to continue using the application ? (Y/N)\n ");
            Scanner y = new Scanner(System.in);
            String userIn = y.nextLine();
          if(userIn.equals("Y") || userIn.equals("y"))
          {
                beneficiaryMenu(beneficiary);
          }
          else if(userIn.equals("N") || userIn.equals("n"))
          {
                System.out.println("\nThank you for using the application!");
                System.exit(0);
          }
    }
    
    
    // REGISTRATION MENU 
    public void registrationMenu()
    {
        String name, phone;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        
        System.out.println("\n Would you like to register as: "
                          + "\n  1. Donator "
                          + "\n  2. Beneficiary"
                          + "\n  3. Exit      ");
        int choice = scanner.nextInt();
          
        switch(choice)
           {
                 case 1: //παίρνει τα στοιχεία του υποψήφιου Donator
                 System.out.println("\nPlease enter your full name: ");
                 name = sc.nextLine();
                 System.out.println("\nPlease enter your phone number: ");
                 phone = sc1.nextLine();
                 
                 Donator newDon = new Donator(name, phone);
                 org.insertDonator(newDon);
                 System.out.println("User successfully created! \n\n");
                 donatorMenu(newDon);
                 break;
                 
                 case 2: //παίρνει τα στοιχεία του υποψήφιου Beneficiary
                 int noPersons;
                 System.out.println("\nPlease enter your full name: ");
                 name = sc.nextLine();
                 System.out.println("\nPlease enter your phone number: ");
                 phone = sc1.nextLine();

                 System.out.println("\nPlease enter the number of people in your family: ");
                 noPersons = scanner.nextInt();
 
                 Beneficiary newBen = new Beneficiary(name, phone, noPersons);
                 org.insertBeneficiary(newBen);
                 System.out.println("\nUser successfully created! \n\n");   
                 beneficiaryMenu(newBen);
                 break;
                 
                 case 3:
                 System.out.println("Thank you for using our application");
                 System.exit(0);
                  
                 default: //σε περίπτωση που δεν επιλεχθεί 1||2||3
                 System.out.println("\nInvalid input, please try again");
                 registrationMenu();
                
           }
    }
       
}

