package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialTransactionAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialTransactionAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(double transactionAmount) {
        this.transactions.add(transactionAmount);
        System.out.println("The transaction of " + transactionAmount + " has been added successfully.");

    }






}