package Assignment_Bank;

/**
 * The Checking Account Class
 */
public class CheckingAccount extends Account {
    /**Attributes
     overDraftLimit
     Methods
     withdraw(int amount) → Need to account for the overdraftLimit. (getBalance + overDraftLimit)
     toString() → provide the needed info for this type of account
     */
    double OverDraftLimit;

    /**
     * The CheckingAccount Constructor
     * @param name the name
     * @param number the account number
     * @param overdraftLimit the overdraftLimit
     */
    public CheckingAccount(String name,int number, double overdraftLimit) {
        super(name,number);
        this.OverDraftLimit = overdraftLimit;
    }

    /**
     * Withdraw from account
     * @param amount account number
     * @return true/false
     */
    boolean withdraw(double amount){
        if (this.getBalance() + this.OverDraftLimit > amount) {
            super.withdraw(amount);
            return true;
        }
        else return false;
    }

    /**
     * returns all the info of this account
     * @return all info of the account
     */
    @Override
    public String toString(){
        return "Name: " + this.name + ", Account number: " + this.getAccountNumber()+ ", Type: Savings Account, Over Draft: " + this.OverDraftLimit+ ", Balance: " + this.getBalance();
    }
}



