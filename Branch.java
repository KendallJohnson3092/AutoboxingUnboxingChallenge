package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customerList;


    public Branch(String branchName) {
        this.branchName = branchName;
        this.customerList = new ArrayList<Customer>();
    }



    public boolean addCustomerToBranch(String name, double initialTransactionAmount) {
        if(findCustomer(name) == null){
            System.out.println("The customer " + name + " has sucessfully been added");
            this.customerList.add(new Customer(name, initialTransactionAmount));
            return true;
        }

        return false;
    }

    public boolean addTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(transaction);
            return true;
        }
            return false;
        }

    private Customer findCustomer(String customerName) {

        for(int i=0;i<customerList.size();i++) {
            Customer checkedCustomer = this.customerList.get(i);
            if(checkedCustomer.getName().equals(customerName)) {

                return checkedCustomer;
            }
        }
        return null;
    }



    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public void listCustomers() {
        for (int i=0; i<=getCustomerList().size();i++) {

            System.out.println(getCustomerList().get(i).getName());
        }

    }
}
