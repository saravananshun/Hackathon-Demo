package com.hackathon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int accountNumber;
    private String productName;
    private String alias;
    private String currency;
    private String iBanAccountNumber;
    private double balance;

    public Account() {
        super();
    }

    public Account(int accountNumber, String productName, String alias, String currency,
                   String iBanAccountNumber, double balance){
        this.accountNumber = accountNumber;
        this.productName = productName;
        this.iBanAccountNumber = iBanAccountNumber;
        this.balance = balance;
        this.alias = alias;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getiBanAccountNumber() {
        return iBanAccountNumber;
    }

    public void setiBanAccountNumber(String iBanAccountNumber) {
        this.iBanAccountNumber = iBanAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
