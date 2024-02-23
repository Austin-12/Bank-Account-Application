import java.util.List;
import java.util.LinkedList;

public class BankAccountApp {

    public static void main(String[] args) {
        //data structure for the objects
        List<Account> accounts = new LinkedList<Account>();

        //the cvs ride i will read
        String file = "C:\\Users\\austi\\OneDrive\\Desktop\\Projects\\Java projects\\bankAccountApp\\NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);

        //loop through list and read into respective variables
        for (String[] accountHolder: newAccountHolders) {
            String name = accountHolder[0];
            String sSn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            
           //open accounts based on the account type and add savings object to linkedlist
            if(accountType.equals("Savings")) {
              //  System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name, sSn, initDeposit));
            }
            else if(accountType.equals("Checking")) {
               // System.out.println("OPENING A CHECKING ACCOUNT");
                accounts.add(new Checking(name, sSn, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        //iterate through linkedlist call showinfo for every object
        for (Account acc : accounts) {
            acc.showInfo();
            System.out.println("\n**************");
        }
    
        //showing features of accounts
        accounts.get(0).deposit(2000);
        System.out.println("\n");
        accounts.get(5).withdraw(20);
        System.out.println("\n");
        accounts.get(9).transfer("Brokerage", 56);
        System.out.println("\n");
        accounts.get(10).compound();
       
    }
}
