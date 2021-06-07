public class RequestDonation{

    private Entity entity;
    private double quantity;
   
    public RequestDonation(Entity entity, double quantity){
    this.entity=entity;
    this.quantity=quantity;
}
   public String getInfo(){ return this.entity.getEntityInfo() + " \nQuantity:" + this.quantity;}
   public double getQuantity(){return this.quantity;}
}