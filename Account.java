public abstract class Account implements IBaseRate { //parent class (not able to make objects) abstract
    //common properties for savings and checking accounts
    private String name;
    private String sSN;    
    private double balance;

    private static int index = 10000;
    protected String accountNumber; //protects it from the outside world but allows it to be used by child classes
     protected double rate;

    //constructor to set base properties and initailize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
    
        //set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    //checking & savings must implement this method
    public abstract void setRate();

    //last2 of snn + uniqueID + 3 random numbers
    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + index + randomNumber;

        

    }

    //compound interest function
    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    //common methods - transactions
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    
    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: " + balance);
    }
    //method to print the information for accounts
    public void showInfo() {
        System.out.println(
            "NAME: " + name +
            "\nACCOUNT NUMBER: " + accountNumber +
            "\nBALANCE: " + balance +
            "\nRATE: " + rate + "%"
        );
    }
    
}
