package Assignment_Bank;

public class SavingsAccount extends Account {
    /*
    Attributes
        interestRate
    Methods
        Private applyInterest() (newBalance = currentBalance (1+interestRate12)12)
        toString() → Need to show: account holder’s name, the account number, the type of account, the account’s interest rate, and the current balance of the account.
        deposit() → calculate and add interest
     */
    private final double interestRate;

    /**
     * The Savings Account
     * @param name the name
     * @param number the account number
     * @param interestRate the interest rate
     */
    public SavingsAccount(String name, int number, double interestRate) {
        super(name, number);
        this.interestRate = interestRate;
    }

    /**
     * Apply interest
     * @return the compound interst formula
     */
    double applyInterest(){
        return this.getBalance()*Math.pow(super.getBalance()*(1+ interestRate /12), 12);
    }

    /**
     * Return
     * @param amount amount to deposit in account
     */
    void deposit(double amount) {
        super.deposit(amount);
        super.deposit(this.applyInterest()-this.getBalance());
    }

    /**
     * returns all the info of this account
     * @return all info of the account
     */
    @Override
    public String toString(){
        return "Name: " + this.name + ", Account number: " + this.getAccountNumber()+ ", Type: Savings Account, Interest Rate: " + this.interestRate + ", Balance: " + this.getBalance();
    }
}
