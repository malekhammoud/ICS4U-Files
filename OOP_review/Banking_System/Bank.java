package OOP_review.Banking_System;
import java.util.*;
/**
 * Write a Java program to create a banking system with these classes: Bank, Account, SavingsAccount, and CurrentAccount.
 * The bank should have a list of accounts and methods for adding them.
 * Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances.
 * SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.
 */
public class Bank {
    HashMap<String, SavingsAccount> savingsAccounts = new HashMap<>();
    HashMap<String, CurrentAccount> CurrentAccounts = new HashMap<>();
    public Bank() {
        ArrayList<Account> test = new ArrayList<Account>();
        savingsAccounts.put("test", new SavingsAccount(1000, 1.03, 2323, 200.4, 30));
        savingsAccounts.put("test2", new SavingsAccount(1000, 1.03, 2323, 2000.4, 30));
    }
    public void printData(){
        for (SavingsAccount savingsAccount : savingsAccounts.values()) {
            System.out.println(savingsAccount.getBalance());
        }

    }

}
