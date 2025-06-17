package Assignment_Bank;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {
    static HashMap<Integer, Account> users = new HashMap<>();
    public static void main(String[] args) {
        /**
         * Diego Martin has a checking account that currently has $668.57 deposited in it and an overdraft limit of $100.00;
         * Janice Watt has a savings account with $120.00 deposited, an interest rate of 1.90%;
         * Michael Rose has a checking account that currently has $37.65 deposited in it and an overdraft limit of $0.00
         */
        users.put(1000, new CheckingAccount("Diego Martin",1000,100.00));
        users.get(1000).deposit(668.57);
        users.put(1001, new SavingsAccount("Janice Watt", 1001, 1.90));
        users.get(1001).deposit(120);
        users.put(1002, new CheckingAccount("Micheal Rose",1002,0.0));
        users.get(1002).deposit(37.65);


        //Main program loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a choice:\nCreate a new account: create\nDisplay account details: display\nDeposit money into an account: deposit\nWithdraw money from an account: withdraw\nQuit your session: quit\n");
        while (true) {
            String input = null;
            try {
                input = scanner.nextLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                if (input.equals("display")) {
                    while (true){
                        System.out.println("please enter the account number:");
                        int acc = scanner.nextInt();
                        if (users.containsKey(acc)) {
                            System.out.println(users.get(acc).toString());
                            break;
                        }
                        else{
                            System.out.println("Account not found");
                        }
                    }

                }else if (input.equals("deposit")) {
                    while (true){
                        System.out.println("Enter the Account Number: ");
                        int acc = scanner.nextInt();
                        if (users.containsKey(acc)) {
                            System.out.println("Enter the amount to deposit: ");
                            double amount = scanner.nextDouble();
                            users.get(acc).deposit(amount);
                            break;
                        }
                        else{
                            System.out.println("Account not found");
                        }
                    }


                }else if (input.equals("withdraw")) {
                    while (true){
                        System.out.println("Enter the Account Number: ");
                        int acc = scanner.nextInt();
                        if (users.containsKey(acc)) {
                            while (true) {
                                System.out.println("Enter the amount to Withdraw: ");
                                double amount = scanner.nextDouble();
                                if (!users.get(acc).withdraw(amount)) {
                                    System.out.println("Withdraw failed, try again");
                                } else {
                                    System.out.println("Withdraw Sucess");
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Account not found");
                        }

                    }

                }else if (input.equals("create")) {
                    int acc;
                    while (true){
                        System.out.println("Enter the Account Number: ");
                        acc = scanner.nextInt();
                        boolean exists = false;
                        for (int i: users.keySet()){
                            if (i == acc){
                                System.out.println("Account already exists");
                                exists = true;
                            }
                        }
                        if (!exists){
                            break;
                        }
                    }
                    System.out.println("Enter the name: ");
                    String name = scanner.next();
                    System.out.println("Enter the Type of account('savings' or 'checking'): ");
                    String type = scanner.next();
                    if (type.equals("savings")) {
                        System.out.println("Enter the interest rate: ");
                        double rate = scanner.nextDouble();
                        users.put(acc, new SavingsAccount(name, acc, rate));

                    }else{
                        System.out.println("Enter the Overdraft limit: ");
                        double overdraft = scanner.nextDouble();
                        users.put(acc, new CheckingAccount(name, acc, overdraft));
                    }
                    System.out.println("Enter initial deposit");
                    double deposit = scanner.nextDouble();
                    users.get(acc).deposit(deposit);
                    System.out.println("Account created successfully");
                }else if (input.equals("quit")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}