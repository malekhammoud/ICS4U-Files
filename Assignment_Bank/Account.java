package Assignment_Bank;

/**
 * The Main abstract class for the Bank
 */
public abstract class Account {
    /*
    Attributes
        Account holder name
        Account number (4 digit)
        Account balance
    Methods
        withdraw(int amount)
        deposit(int amount)
        setName()/getName()
        getAccountNumber()
        getBalance()
        toString()
     */
    String name;
    private final int number;
    private int balance;

    /**
     * Account Contructor
     * @param name the name
     * @param number account number
     */
    Account(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Getter method for account number
     * @return the account number
     */
    int getAccountNumber(){
        return this.number;
    }

    /**
     * Deposit money into the account
     * @param amount amount to deposit in account
     */
    void deposit(double amount){
        this.balance += amount;
    };

    /**
     * Withdraw from account
     * @param amount account number
     * @return true/false
     */
    boolean withdraw(double amount){
        this.balance -= amount;
        return true;
    }

    /**
     * Getter method for name
     * @return the name
     */
    String getName(){
        return this.name;
    }

    /**
     * Getter Method for the balance
     * @return the balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * Abstract Method
     * @return all info of the account
     */
    public abstract String toString();
}

