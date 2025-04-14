package OOP_review.Banking_System;

/**
 * Write a Java program to create a banking system with these classes: Bank, Account, SavingsAccount, and CurrentAccount.
 * The bank should have a list of accounts and methods for adding them.
 * Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances.
 * SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.
 */
public class CurrentAccount implements Account {
    private int interestRate;
    private int accountNumber;
    private double accountBalance;

    CurrentAccount(int interestRate, int accountNumber, double accountBalance) {
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    @Override
    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        this.accountBalance -= amount;
        return true;
    }

    @Override
    public double calculateInterest(int days) {
        return 0;
    }

    @Override
    public double getBalance() {
        return this.accountBalance;
    }
}
