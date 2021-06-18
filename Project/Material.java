public class Material extends Entity{
    private double level1, level2, level3;
    
    public Material(String name, String description, int id, double level1, double level2, double level3){ 
    super(name, description, id);
    this.level1 = level1;
    this.level2 = level2;
    this.level3 = level3;
     }
    @Override
    public String getDetails()
    {return getEntityInfo() + "\nSingle person families are entitled to " + this.level1 + " of this material \n" 
                            + "2-4 member families are entitled to " + this.level2 + " of this material \n"
                            + "5+ member families are entitled to " + this.level3 + " of this material \n"      ;} 
  
    
    
    
    
}
