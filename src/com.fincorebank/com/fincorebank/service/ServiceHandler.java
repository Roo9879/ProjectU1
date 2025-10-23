package com.fincorebank.service;

import java.util.Scanner;
import com.fincorebank.model.*;

public class ServiceHandler implements AccountService {
    private Scanner scanner;

    //constructor
    public ServiceHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void deposit(Account account) {
        System.out.print("\nEnter your amount to deposit (or 'x' to cancel) : £");
        String depositInput = scanner.nextLine();
        if (!depositInput.equalsIgnoreCase("x")) {
            try {
                double depositAmount = Double.parseDouble(depositInput);
                account.makeDeposit(depositAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        } else {
            System.out.println("\nDeposit cancelled, returning to main menu.");
        }
    }

    @Override
    public void withdraw(Account account) {
        System.out.print("\nEnter your amount to withdraw (or 'x' to cancel): £");
        String withdrawalInput = scanner.nextLine();
        if (!withdrawalInput.equalsIgnoreCase("x")) {
            try {
                double withdrawalAmount = Double.parseDouble(withdrawalInput);
                account.makeWithdrawal(withdrawalAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        } else {
            System.out.println("\nWithdrawal cancelled, returning to main menu");
        }
    }

    @Override
    public void checkBalance(Account account) {
        System.out.println("\n=== Account Balance ===");
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: " + account.getCurrentBalance());

        // show overdraft for checking account
        if (account instanceof CheckingAccount) {
            CheckingAccount chk = (CheckingAccount) account;
            System.out.println("Overdraft limit: £" + chk.getOverdraftLimit());
            System.out.println("Available Funds: £" + (account.getCurrentBalance() + chk.getOverdraftLimit()));
        }

        //show interest rate for savings account
        if (account instanceof SavingsAccount) {
            SavingsAccount sav = (SavingsAccount) account;
            System.out.println("Interest Rate: " + sav.getInterestRate() + "%");
        }
    }

    @Override
    public void deleteAccount(Account account, DataStore dataStore) {
        System.out.println("\n Are you sure you want to delete your account? (y/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            dataStore.deleteAccount(account.getAccountNumber());
            System.out.println("Account deleted successfully");
        } else {
            System.out.println("Account deletion cancelled");
        }
    }
}
