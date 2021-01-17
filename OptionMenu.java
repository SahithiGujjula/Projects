package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(1234567, 9876);
                data.put(9876543, 1234);
                System.out.println("Welcome to ATM!");
                System.out.print("Enter Your Customer Number: ");
                SetCustomerNumber(menuInput.nextInt());
                System.out.print("Enter Your Pin Number: ");
                SetPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n"+"Invalid Character(s). Enter Only numbers."+"\n");
                x=2;
            }
            for(Map.Entry<Integer, Integer> entry: data.entrySet()){
                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n"+"Wrong Customer Number or Pin Number."+"\n");
        }
        while(x==1);
    }

    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1: checking Account");
        System.out.println("Type 2: savings Account");
        System.out.println("Type 3: Exit");
        System.out.print("Enter Your Choice: ");
        selection = menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for Using ATM.");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Savings Account: ");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.print("Enter Your Choice: ");
        selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("checkings Account Balance: "+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for Using ATM.");
                break;
            default:
                System.out.println("\n"+"Invalid choice."+"\n");
                getChecking();
        }
    }


    public void getSaving(){
        System.out.println("Savings Account: ");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.print("Choice");
        selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("savings Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for Using ATM.");
                break;
            default:
                System.out.println("\n"+"Invalid choice."+"\n");
                getSaving();
        }
    }
    int selection;



}