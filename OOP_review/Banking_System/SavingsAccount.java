package OOP_review.Banking_System;

/**
 * Write a Java program to create a banking system with these classes: Bank, Account, SavingsAccount, and CurrentAccount.
 * The bank should have a list of accounts and methods for adding them.
 * Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances.
 * SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.
 */
public class SavingsAccount implements Account {
    private int withdrawLimit;
    private double interestRate;
    private int accountNumber;
    private double accountBalance;
    private final int interestCount;

    SavingsAccount(int withdrawLimit, double interestRate, int accountNumber, double accountBalance, int interestCount) {
        this.withdrawLimit = withdrawLimit;
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.interestCount = interestCount;
    }
    @Override
    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= this.withdrawLimit) {
            this.accountBalance -= amount;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double calculateInterest(int days) {
        return interestRate*(days%interestCount)*this.accountBalance;
    }

    @Override
    public double getBalance() {
        return this.accountBalance;
    }
}
