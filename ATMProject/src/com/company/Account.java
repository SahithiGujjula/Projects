package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");
    //set the customer number
    public int SetCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    //get the customer number
    public int getCustomerNumber(){
        return customerNumber;
    }
    // set the pin
    public int SetPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    // get the pin number
    public int getPinNumber(){
        return pinNumber;
    }
    //
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingBalance(){
        return savingBalance;
    }


    public double calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.print("Enter Amount to Withdraw from checking Account: ");
        double amount = input.nextDouble();
        if((checkingBalance - amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance));
        } else{
            System.out.println("Insufficient Funds. Please Enter valid amount."+"\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
        System.out.print("Enter Amount to Withdraw from saving Account: ");
        double amount = input.nextDouble();
        if((savingBalance - amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+savingBalance+ "\n");
        } else{
            System.out.println("Insufficient Funds. Please Enter valid amount."+"\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.print("Enter Amount to deposit into Checking Account: ");
        double amount = input.nextDouble();
        if((checkingBalance + amount)>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: "+moneyFormat.format(checkingBalance));
        } else{
            System.out.println("Insufficient Funds. Please check again."+"\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
        System.out.println("Enter Amount to deposit into Saving Account: ");
        double amount = input.nextDouble();
        if((savingBalance + amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
        } else{
            System.out.println("Insufficient Funds. Please check again."+"\n");
        }
    }

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;


}
