package OOP_review.Banking_System;

/**
 * Write a Java program to create a banking system with these classes: Bank, Account, SavingsAccount, and CurrentAccount.
 * The bank should have a list of accounts and methods for adding them.
 * Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances.
 * SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.
 */
public interface Account {
    void deposit(double amount);
    boolean withdraw(double amount);
    double calculateInterest(int days);
    double getBalance();
}
