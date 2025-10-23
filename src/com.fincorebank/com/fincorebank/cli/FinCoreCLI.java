package com.fincorebank.cli;

import com.fincorebank.model.*;
import com.fincorebank.service.*;

import java.util.Scanner;

public class FinCoreCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // initialise DataStore and ServiceHandler
        AccountService handler = new ServiceHandler(scanner);
        DataStore dataStore = new InMemoryDataStore();

        //creating bank accounts
        dataStore.addAccount(new Account("Jane Doe", 1000));//normal account
        dataStore.addAccount(new CheckingAccount("John Doe", 500, 200)); // checking account
        dataStore.addAccount(new SavingsAccount("Jacob Doe", 2000, 1.25));//savings account

        System.out.println("\nWelcome to FinCore CLI Banking!");

        //let user select account by name
        Account currentAccount = null;
        while (currentAccount == null) {
            System.out.print("\nEnter account holder name to access your account: ");
            String name = scanner.nextLine();
            currentAccount = dataStore.findAccountByName(name);
            if (currentAccount == null) {
                System.out.println("Account not found. PLease try again.");
            }
        }

        //Display basic account info
        System.out.println("\nAccount Holder: " + currentAccount.getAccountHolderName());
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Initial Balance: £" + currentAccount.getCurrentBalance());

        //main menu display
        String option;

        do {
            System.out.println("\n=== FinCore CLI Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("5. Delete Account");
            System.out.println("Please select an option (input number 1-5): ");
            option = scanner.nextLine();

            switch (option) {
                case "1": //deposit
                    handler.deposit(currentAccount);
                    break;
                case "2": //withdraw
                    handler.withdraw(currentAccount);
                    break;
                case "3": //check balance
                    handler.checkBalance(currentAccount);
                    break;
                case "4": //exit
                    System.out.println("\nThank you for using FinCore CLI Banking!");
                    break;
                case "5": //delete account
                    handler.deleteAccount(currentAccount, dataStore);
                    System.out.println("\n Thank you for using FinCore CLI Banking! Goodbye!");
                    option = "4"; //breaks loop and exits
                    break;
                default: //invalid choices
                    System.out.println("Invalid choice. Please try again and enter a number between 1 and 4.");
                    break;
            }
        } while (!option.equals("4"));
        scanner.close();
    }
}