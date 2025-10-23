package com.fincorebank.cli;

import com.fincorebank.model.*;
import com.fincorebank.service.AccountService;
import com.fincorebank.service.ServiceHandler;

import java.util.Scanner;

public class FinCoreCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountService handler = new ServiceHandler(scanner);
        AccountManager accountManager = new AccountManager();

        //creating bank accounts
        accountManager.addAccount(new Account("Jane Doe", 1000)); //normal account
        accountManager.addAccount(new CheckingAccount("John Doe", 500, 200)); // checking account
        accountManager.addAccount(new SavingsAccount("Jacob Doe", 2000, 1.25));//savings account

        System.out.println("\nWelcome to FinCore CLI Banking!");

        //let user select account by name
        Account currentAccount = null;
        while (currentAccount == null) {
            System.out.print("\nEnter account holder name to access your account: ");
            String name = scanner.nextLine();
            currentAccount = accountManager.findAccountByName(name);
            if (currentAccount == null) {
                System.out.println("com.fincorebank.model.Account not found. PLease try again.");
            }
        }

        //Display basic account info
        System.out.println("\ncom.fincorebank.model.Account Holder: " + currentAccount.getAccountHolderName());
        System.out.println("com.fincorebank.model.Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Initial Balance: £" + currentAccount.getCurrentBalance());

        //main menu display
        String option;

        do {
            System.out.println("\n=== FinCore CLI Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Please select an option (input number 1-4): ");
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
                default: //invalid choices
                    System.out.println("Invalid choice. Please try again and enter a number between 1 and 4.");
                    break;
            }
        } while (!option.equals("4"));
        scanner.close();
    }
}