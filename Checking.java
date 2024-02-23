public class Checking extends Account {
    //properties specific to checking account
    private int debitCardNumber;
    private int debitCardPin;
    
    //constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
        
    }
    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }
    //generate random 12digit # for debitcard and 4 for pin
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }
    //print this along with the print info in account class
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println(
            "Your Checking Account Features" +
            "\n Debit Card Number: " + debitCardNumber +
            "\n Debit Card Pin: " + debitCardPin
        );
        
    }
    
}