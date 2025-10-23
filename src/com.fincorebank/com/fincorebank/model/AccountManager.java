package com.fincorebank.model;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountByName (String name) {
        for (Account acc : accounts) {
            if (acc.getAccountHolderName().equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
