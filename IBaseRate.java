public interface IBaseRate { //interest rate coming from outside as if someone else is writing this interface
    
    //write a method that returns a base rate
    //savings accounts will use .25 less than the base rate
    //checking accounts will use 15% of the base rate
    default double getBaseRate() {
        return 2.5;
    }
}
