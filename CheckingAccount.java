//Subclass of BankAccount
public class CheckingAccount extends BankAccount{
   //Static Variables
   public static final int MAX_CHECKS = 1000;
   
   //Instance Variables
   private double[] writtenChecks;
   private int noOfChecks;
   
   //Constructors
   public CheckingAccount(String name, double balance){
      super(name, balance);
      
      //Instantiates the writtenChecks array
      this.writtenChecks = new double[MAX_CHECKS];
   }
   
   //Accessors
   public double[] getWrittenChecks(){
      //Create temp array to avoid backdoor access - violation of information hiding
      double[] tempArray = new double[noOfChecks];
      
      //Assigns value to temporary array
      for(int i=0; i< noOfChecks; i++){
         tempArray[i] = writtenChecks[i];
      }
      
      //Returns array
      return tempArray;
   }
   
   public double getWrittenCheck(int checkNum){
      //Validates if check number has been written
      if(checkNum > noOfChecks){
         throw new IllegalArgumentException("The specified check has not been written");
      }
      
      //Returns specified Check
      return this.writtenChecks[checkNum-1];
   }
   
   //Special Purpose
   //Overwrites super classes behavior from the withdraw method
   public void withdraw(double amount){
      if(noOfChecks >= MAX_CHECKS){
         throw new IllegalArgumentException("You have written the maximum number of checks.");
      }
      
      //Validating the withdrawn amount
      super.withdraw(amount);
      
      //Added the written check
      writtenChecks[noOfChecks] = amount;
      
      //Incrementing the number of checks written
      noOfChecks++;
   } 
   
   //Overwrites super classes behavior from the toString method
   public String toString(){
      //Retrieves generic account summary from super class toString
      String accountSummary = super.toString();
      
      //Adds Written Checks if number is greater than zero
      if(noOfChecks > 0){
          accountSummary+="\n\n--CHECKS WRITTEN--\n\n";
          
         for(int i = 0 ; i< noOfChecks; i++){
            accountSummary+= "Check no."+(i+1)+". "+String.format("$%.2f",this.getWrittenCheck(i+1));
         }
      }
      
      //Returns Accoutn Summary
      return accountSummary;
   } 
}