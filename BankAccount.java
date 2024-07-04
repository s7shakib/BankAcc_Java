public class BankAccount{
   //Static Variables
   public static final double MIN_BALANCE = 0;
   public static final double MIN_TRANSACTION = 0;
   
   //Instance Variables
   private String name;
   private double balance;
   
   //Constructor
   public BankAccount(String name, double balance){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("An account name must be provided");
      }else if(balance < MIN_BALANCE){
         throw new IllegalArgumentException("An account must have a balance greater than "+String.format("$%.2f",MIN_BALANCE));
      }
      
      this.name = name;
      this.balance = balance;
   }
   
   //Accessors
   public String getName(){ return this.name;}
   public double getBalance(){ return this.balance;}
   
   //Mutators
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("An account name must be provided");
      }
      
      this.name = name;
   }
   
   public void setBalance(double balance){
      if(balance < MIN_BALANCE){
         throw new IllegalArgumentException("An account must have a balance greater than "+String.format("$%.2f",MIN_BALANCE));
      }
      
      this.balance = balance;
   }
   
   //Special Purpose
   public void deposit(double amount){
      validateMinTransaction(amount);
      this.setBalance(this.getBalance() + amount);
   }
   
   public void withdraw(double amount){
      validateMinTransaction(amount);
      
      if(amount > this.getBalance()){
         throw new IllegalArgumentException("The specified amount is greater than the available balance");
      }
      
      this.setBalance(this.getBalance() - amount);
   }
   
   private void validateMinTransaction(double amount){
      if(amount < MIN_TRANSACTION){
         throw new IllegalArgumentException("A transaction must be greater than "+String.format("$%.2f",MIN_BALANCE));
      }
   }
   
   public String toString(){
      return "Account : "+this.getName()+"\nBalance : "+String.format("$%.2f",this.getBalance());
   }
}