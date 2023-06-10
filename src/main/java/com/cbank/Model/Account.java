package com.cbank.Model;

import jakarta.persistence.*;

import java.util.Random;

@Entity
public class Account implements Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    @Column(unique = true)
    private String norek;
    private double balance;

    private String firstName;
    private String lastName;

    @Transient
    private static final String BANK_CODE = "CBANK";

    @Transient
    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    public Account() {
    }

    public Account(String firstName, String lastName) {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(BANK_CODE);

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH - BANK_CODE.length(); i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        this.firstName = firstName;
        this.lastName = lastName;

        norek = accountNumber.toString();
        balance = 0;
    }

    public Account(double balance, String firstName, String lastName) {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(BANK_CODE);

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH - BANK_CODE.length(); i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        norek = accountNumber.toString();
        this.balance = balance;
    }

    public int getAccount_id() {
        return this.account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getNorek() {
        return this.norek;
    }

    public void setNorek(String norek) {
        this.norek = norek;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Account transfer(double amount, Account accountRecipient) {
        if (balance >= amount) {
            balance -= amount;
            accountRecipient.deposit(amount);
            return accountRecipient;
        } else {
            return null;
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
