package com.fincorebank.service;

import com.fincorebank.model.Account;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDataStore implements DataStore{
    private List<Account> accounts;

    public InMemoryDataStore() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Account findAccountByNumber(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }

        }
        return null;
    }

    @Override
    public Account findAccountByName(String accountHolderName) {
        for (Account acc : accounts) {
            if (acc.getAccountHolderName().equalsIgnoreCase(accountHolderName)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts); //return copy for safety
    }

    @Override
    public void updateAccount(Account account) { }
    //don't need anything in updateAccount as deposit, withdraw etc methods update it already
    //but completes CRUD interface and can use it later when building on project

    @Override
    public void deleteAccount(int accountNumber) {
        accounts.removeIf(acc -> acc.getAccountNumber() == accountNumber);
        // lambda expression - for each acc in list, check if account number = given account number, if yes then remove
    }
}
