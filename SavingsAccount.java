//Subclass of BankAccount
public class SavingsAccount extends BankAccount{
   //Static Variables
   public static final double DEPOSIT_BONUS = .01;
   public static final int MAX_WITHDRAWALS = 6;
   
   //Instance Variables
   private int noWithdraws;
   
   //Constructor
   public SavingsAccount(String name, double balance){
      super(name, balance);
   }
   
   //Accessor
   public int getNoWithdraws(){return this.noWithdraws;}
   
   //Mutator
   public void setNoWithdraws(){
      this.noWithdraws = this.getNoWithdraws()+1;
   }
   
   //Special Purpose Methods
   public void withdraw(double amount){
      if(noWithdraws >= MAX_WITHDRAWALS){
         throw new IllegalArgumentException("The month's max withdrawls has been reached!");
      }
      
      super.withdraw(amount);
      this.setNoWithdraws();
   }
   
   public void deposit(double deposit){
      super.deposit(deposit+(deposit*DEPOSIT_BONUS));
   }
   
   public void setNewMonth(){
      this.noWithdraws = 0;
   }
   
   public String toString(){
      return super.toString() +"\nNo. Withdraws :"+this.getNoWithdraws();
   }
}