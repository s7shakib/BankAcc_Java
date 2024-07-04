import javax.swing.JOptionPane;

public class BankAccountImplementation{
   public static void main(String[] args){
      
      BankAccount account = null;
      
      //Based on Account Selection, create either checking or saving account
      do{
         switch(createAccountOption()){
            case "Checking Account": 
               account = createCheckingAccount();
               break;
            case "Saving Account":
               account = createSavingAccount();
               break;
            default: JOptionPane.showMessageDialog(null,"You have selected an invalid option");
         }
      }while(account == null);
      
      //Based on the action selection, either withdraw or deposit an amount
      do{
         switch(createActionOption()){
            case "Withdraw":
               //Calls the Withdraw method within the account object
               account.withdraw(retrieveActionAmount(account,"WITHDRAW"));
               break;
            case "Deposit":
               //Calls the Deposit method within the account object
               account.deposit(retrieveActionAmount(account, "DEPOSIT"));
               break;
            default: JOptionPane.showMessageDialog(null, "You have selected an invalid option");
         }
      }while(JOptionPane.showConfirmDialog(null,"Would you like to perform another action on the account "+ account.getName()+"?", "Another Account Action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
      
      //If account is not null, prints message
      if (account != null){
        JOptionPane.showMessageDialog(null, account.toString());
      }
   }
   
   //Creation of Drop-down Menu (Checking Account or Saving Account)
   public static String createAccountOption(){
      //Creates an array for the String options
      String[] options = {"Checking Account", "Saving Account"};
      
      //Displays a Dropdown menu for the end user
      return (String) JOptionPane.showInputDialog(null, "Select the bank account you would like to create","Bank Account Creation", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
   }
   
   public static String createActionOption(){
      //Creats an array of the String options
      String[] options = {"Withdraw", "Deposit"};
      
      //Shows a list of action buttons
      int selectedAction = JOptionPane.showOptionDialog(null,"Select the option you would like to perform on your account", "Account Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      
      //Returns the selected action
      return options[selectedAction];
   }
   
   //Creates the Checking Account Object
   public static CheckingAccount createCheckingAccount(){
      CheckingAccount account = null;
      
      do{
         try{
            //Instantiates a Checking Account object based on the name and balance of the account 
            account = new CheckingAccount(JOptionPane.showInputDialog("Please enter the NAME of the account"),
                                          Double.parseDouble(JOptionPane.showInputDialog("Please enter the BALANCE of the account")));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a numberical value for the account balance");
         }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(account == null);
            
      return account;
   }
   
   //Creates the Savings Account Object
   public static SavingsAccount createSavingAccount(){
      SavingsAccount account = null;
      
      do{
         try{
            //Instantiates a Checking Account object based on the name and balance of the account 
            account = new SavingsAccount(JOptionPane.showInputDialog("Please enter the NAME of the account"),
                                          Double.parseDouble(JOptionPane.showInputDialog("Please enter the BALANCE of the account")));
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter a numberical value for the account balance");
         }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(account == null);
            
      return account;
   }
   
   //Prompts the user for the amount of the desired action
   public static double retrieveActionAmount(BankAccount account, String action){
      double amount = -1;
      
      do{
         try{
            amount = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount you would like to "+action +"\nCurrent Balance :"+String.format("$%.2f",account.getBalance())));                                          
         }catch(NumberFormatException e){
            amount = -1;
            JOptionPane.showMessageDialog(null, "You have entered an invalid number");
         }
      }while(amount < 0);
      
      return amount;
   }
}