package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> bankBranches;



    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankBranches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {

            this.bankBranches.add(new Branch(branchName));
            return true;
        }
        return false;

    }


    public boolean addCustomer(String name, String branchName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if(branchName !=null) {
            return branch.addCustomerToBranch(name, initialTransaction);
        }
        return false;

    }

    private Branch findBranch(String branchName) {
        for(int i=0;i<bankBranches.size();i++) {
            Branch checkedBranch = this.bankBranches.get(i);
            if(checkedBranch.getBranchName().equals(branchName)) {

                return checkedBranch;
            }
        }

        return null;
    }

    public boolean listCustomersByBranch(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());

            ArrayList<Customer> branchCustomers = branch.getCustomerList();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + i + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));

                    }
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionAmount) {

        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addTransaction(customerName, transactionAmount);
        }

        return false;
    }


}
