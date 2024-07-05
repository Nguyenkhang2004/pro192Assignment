package model;

import model.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Bank {

    private ArrayList<Customer> customerList;
    private String bankUser;
    private String bankPassWord;
    
    public Bank() {
        this.customerList = new ArrayList<>();
        bankUser = "Group9";
        bankPassWord = "se18d06";
    }
    
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    public String getBankPassWord() {
        return bankPassWord;
    }

    public void setBankPassWord(String bankPassWord) {
        this.bankPassWord = bankPassWord;
    }
    
    

    public boolean authenticateCustomer(String username, String password) {
        Customer customer = getCustomerByUserName(username);
        if (customer != null) {
            return password.equals(customer.getPassword());
        }
        return false;
    }

    public void addNewCustomer(Customer newCustomer) {
        boolean checkDuplicate = false;
        for(Customer cus : customerList){
            if(cus.getUsername().equals(newCustomer.getUsername())){
                checkDuplicate = true;
                break;
            }
        }
        if(!checkDuplicate){
        customerList.add(newCustomer);
        System.out.println("Added successfully.");
        } else {
            System.out.println("the user-name of customer must be unique.");
        }
    }

    public void deleteCustomer(String userName) {
        boolean check = customerList.removeIf(customer -> customer.getUsername().equals(userName));
        if (check) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("The customer not found with the given user name.");
        }
    }

    public void displayCustomeList(ArrayList<Customer> customerList) {
        customerList.sort(Comparator.comparing(Customer::getFullName));
        System.out.printf("|%-18s|%-20s|%-15s|%-15s|%-30s|%-12s|\n", 
                "User-Name", "Full-Name", "Account-Number", "Identification", "Mail", "Phone");
        for(Customer cus : customerList){
            System.out.println(cus);
        }
    }

    public ArrayList<Customer> searchCustomerByUserName(String userName) {
        ArrayList<Customer> UserNameList = new ArrayList<>();
        for (Customer cus : customerList) {
            if (cus.getUsername().equals(userName)) {
                UserNameList.add(cus);
            }
        }
        return UserNameList;
    }

    public ArrayList<Customer> searchCustomerByCCCD(String cccd) {
        ArrayList<Customer> cccdList = new ArrayList<>();
        for (Customer cus : customerList) {
            if (cus.getCccd().equals(cccd)) {
                cccdList.add(cus);
            }
        }
        return cccdList;
    }

    public ArrayList<Customer> searchCustomerByName(String name) {
        ArrayList<Customer> sameNameList = new ArrayList<>();
        for (Customer cus : customerList) {
            if (cus.getFullName().contains(name)) {
                sameNameList.add(cus);
            }
        }
        return sameNameList;
    }

    public Customer getCustomerByUserName(String userName) {
        for (Customer cus : customerList) {
            if (cus.getUsername().equals(userName)) {
                return cus;
            }
        }
        return null;
    }
    
}
