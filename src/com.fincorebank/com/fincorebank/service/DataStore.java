package com.fincorebank.service;

import com.fincorebank.model.Account;
import java.util.List;
//interface for CRUD implementation
public interface DataStore {
    void addAccount(Account account); //create
    Account findAccountByNumber(int accountNumber); //read
    Account findAccountByName(String name); //read
    List<Account> getAllAccounts(); //read all
    void updateAccount(Account account); //update
    void deleteAccount(int accountNumber); //delete
}