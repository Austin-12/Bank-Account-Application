public class Savings extends Account {
    
    //list properties specific to savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    //constructor to initalize settings for savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit); //calls parent constructor with arguments
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() -  .25;
    }

    //generate 3 digit # for boxID and 4 for the key
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));

    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println(
            "Your Savings Account Features" +
            "\n Safety Deposit Box ID: " + safetyDepositBoxID +
            "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
  

    //list any methods specific to savings account
}
