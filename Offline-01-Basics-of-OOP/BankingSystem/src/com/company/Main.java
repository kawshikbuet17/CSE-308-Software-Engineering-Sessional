package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Account{
    protected String accountName;
    protected double accountBalance;
    protected double pendingLoan;
    protected double paidLoan;

    public Account(String accountName, double accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        pendingLoan = 0;
        paidLoan = 0;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public String getAccountName() {
        return accountName;
    }
    public double getAccountBalance() {
        return accountBalance;
    }

    abstract public void dipositMoney(double amount);
    abstract public void withdrawMoney(double amount);
    abstract public void requestLoan(double amount, double internalFund);

    public double getPendingLoan() {
        return pendingLoan;
    }
    public void setPendingLoan(double pendingLoan) {
        this.pendingLoan = pendingLoan;
    }
    public double getPaidLoan() {
        return paidLoan;
    }
    public void setPaidLoan(double paidLoan) {
        this.paidLoan = paidLoan;
    }
}

class Savings extends Account{
    public Savings(String accountName, double accountBalance) {
        super(accountName, accountBalance);
        System.out.println("Savings account for " + accountName + " Created; initial balance " + accountBalance + "$");
    }
    public void dipositMoney(double amount){
        setAccountBalance(getAccountBalance() + amount);
    }
    public void withdrawMoney(double amount){
        if (getAccountBalance() - amount >= 1000){
            setAccountBalance(getAccountBalance() - amount);
        }
        else{
            System.out.println("Invalid Transaction Request");
        }

    }
    public void requestLoan(double amount, double internalFund){
        if (amount <= 10000 && internalFund > amount){
            pendingLoan = amount;
            System.out.println("Loan request successful, sent for approval");
        }
        else
            System.out.println("not more than 10000");
    }
}

class Student extends Account{
    public Student(String accountName, double accountBalance) {
        super(accountName, accountBalance);
        System.out.println("Student account for " + accountName + " Created; initial balance " + accountBalance + "$");
    }
    public void dipositMoney(double amount){
        setAccountBalance(getAccountBalance() + amount);
    }
    public void withdrawMoney(double amount){
        if (amount <= 10000 && accountBalance-amount > 0)
            setAccountBalance(getAccountBalance() - amount);
        else
            System.out.println("Can't withdraw more than 10000");
    }
    public void requestLoan(double amount, double internalFund){
        if (amount <= 1000 && internalFund > amount){
            pendingLoan = amount;
            System.out.println("Loan request sent");
        }
        else
            System.out.println("not more than 1000");
    }
}

class FixedDiposit extends Account{
    public FixedDiposit(String accountName, double accountBalance) {
        super(accountName, accountBalance);
        System.out.println("FixedDiposit account for " + accountName + " Created; initial balance " + accountBalance + "$");
    }
    public void dipositMoney(double amount){
        if (amount > 50000) {
            setAccountBalance(getAccountBalance() + amount);
        }
        else {
            System.out.println("Amount should be greater than 50000$");
        }
    }
    public void withdrawMoney(double amount){
        if (amount <= 10000 || accountBalance-amount > 0)
            setAccountBalance(getAccountBalance() - amount);
        else
            System.out.println("Can't withdraw more than 10000");
    }
    public void requestLoan(double amount, double internalFund){
        if (amount <= 100000  && internalFund > amount){
            pendingLoan = amount;
            System.out.println("Loan request sent");
        }
        else
            System.out.println("not more than 100000");
    }
}

class Employee{
    private String employeeType;
    public Employee(String employeeType) {
        this.employeeType = employeeType;
    }
    public double lookUp(int[] index, List<Savings> savingsAccounts, List<Student> studentAccounts, List<FixedDiposit> fixedAccounts){
        if (index[0]==1){
            return savingsAccounts.get(index[1]).getAccountBalance();
        }
        else if(index[0]==2){
            return studentAccounts.get(index[1]).getAccountBalance();
        }
        else {
            return fixedAccounts.get(index[1]).getAccountBalance();
        }
    }

    public void viewLoan(List<Savings> savingsAccounts, List<Student> studentAccounts, List<FixedDiposit> fixedAccounts){
        if (!employeeType.equals("officer") && !employeeType.equals("managingDirector")){
            System.out.println("You don't have access");
        }
        else {
            for(int i = 0; i<savingsAccounts.size(); i++){
                Savings acc = savingsAccounts.get(i);
                if (acc.getPendingLoan()>0)
                    System.out.println(acc.getAccountName() + " - pending - " + acc.getPendingLoan());
            }

            for(int i = 0; i<studentAccounts.size(); i++){
                Student acc = studentAccounts.get(i);
                if (acc.getPendingLoan()>0)
                    System.out.println(acc.getAccountName() + " - pending - " + acc.getPendingLoan());
            }

            for(int i = 0; i<fixedAccounts.size(); i++){
                FixedDiposit acc = fixedAccounts.get(i);
                if (acc.getPendingLoan()>0)
                    System.out.println(acc.getAccountName() + " - pending - " + acc.getPendingLoan());
            }
        }
    }

    public double approveLoan(int[] index, List<Savings> savingsAccounts, List<Student> studentAccounts, List<FixedDiposit> fixedAccounts){
        if (!employeeType.equals("officer") && !employeeType.equals("managingDirector")){
            System.out.println("You don't have access");
            return 0;
        }
        else {
            if (index[0] == 1){
                Savings acc = savingsAccounts.get(index[1]);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                System.out.println("Approved");
                return acc.getPaidLoan();
            }
            else if (index[0] == 2){
                Student acc = studentAccounts.get(index[1]);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                System.out.println("Approved");
                return acc.getPaidLoan();
            }
            else {
                FixedDiposit acc = fixedAccounts.get(index[1]);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                System.out.println("Approved");
                return acc.getPaidLoan();
            }
        }
    }
    public double approveAllLoan(List<Savings> savingsAccounts, List<Student> studentAccounts, List<FixedDiposit> fixedAccounts){
        if (!employeeType.equals("officer") && !employeeType.equals("managingDirector")){
            System.out.println("You don't have access");
            return 0;
        }
        else {
            double total = 0;
            for(int i = 0; i<savingsAccounts.size(); i++){
                Savings acc = savingsAccounts.get(i);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                total += acc.getPaidLoan();
            }

            for(int i = 0; i<studentAccounts.size(); i++){
                Student acc = studentAccounts.get(i);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                total += acc.getPaidLoan();
            }

            for(int i = 0; i<fixedAccounts.size(); i++){
                FixedDiposit acc = fixedAccounts.get(i);
                acc.setPaidLoan(acc.getPendingLoan());
                acc.setPendingLoan(0);
                acc.setAccountBalance(acc.getAccountBalance()+acc.getPaidLoan());
                total += acc.getPaidLoan();
            }
            System.out.println("All Loans Approved");
            return total;
        }
    }
    public double[] changeInterestRate(String accountType, double rate){
        double[] newInterestRate = new double[2];
        if (employeeType.equals("managingDirector")){
            if(accountType.equals( "savings")){
                newInterestRate[0] = 1;
                newInterestRate[1] = rate;
            }
            else if (accountType.equals("student")){
                newInterestRate[0] = 2;
                newInterestRate[1] = rate;
            }
            else {
                newInterestRate[0] = 3;
                newInterestRate[1] = rate;
            }
        }
        return newInterestRate;
    }
    public void seeInternalFund(double amount){
        if (employeeType.equals("managingDirector")){
            System.out.println("Internal Fund = " + amount);
        }
        else
            System.out.println("You dont have access");
    }
}

class Bank{
    private double internalFund;
    private int clock;
    private double savingsInterestRate;
    private double studentInterestRate;
    private double fixedInterestRate;
    private double loanInterestRate;

    public Employee MD, O1, O2, C1, C2, C3, C4, C5;
    private List<Savings> savingsAccounts = new ArrayList<Savings>();
    private List<Student> studentAccounts = new ArrayList<Student>();
    private List<FixedDiposit> fixedAccounts = new ArrayList<FixedDiposit>();

    public Bank(double initialFund, int clock) {
        this.internalFund = initialFund;
        this.clock = clock;

        MD = new Employee("managingDirector");
        O1 = new Employee("officer");
        O2 = new Employee("officer");
        C1 = new Employee("cashier");
        C2 = new Employee("cashier");
        C3 = new Employee("cashier");
        C4 = new Employee("cashier");
        C5 = new Employee("cashier");

        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");

        savingsInterestRate = 0.10;
        studentInterestRate = 0.05;
        fixedInterestRate = 0.15;
        loanInterestRate = 0.10;
    }

    // Update Clock
    public void updateClock(){
        clock = clock + 1;
        System.out.println(clock + " year passed.");

        for (int i=0; i<savingsAccounts.size(); i++){
            Savings acc = savingsAccounts.get(i);
            acc.setAccountBalance(acc.getAccountBalance() + acc.getAccountBalance() * savingsInterestRate);
            acc.setAccountBalance(acc.getAccountBalance() - 500);
            acc.setAccountBalance(acc.getAccountBalance() - acc.getPaidLoan()*loanInterestRate);
        }

        for (int i=0; i<studentAccounts.size(); i++){
            Student acc = studentAccounts.get(i);
            acc.setAccountBalance(acc.getAccountBalance() + acc.getAccountBalance() * studentInterestRate);
            acc.setAccountBalance(acc.getAccountBalance());
            acc.setAccountBalance(acc.getAccountBalance() - acc.getPaidLoan()*loanInterestRate);
        }

        for (int i=0; i<fixedAccounts.size(); i++){
            FixedDiposit acc = fixedAccounts.get(i);
            acc.setAccountBalance(acc.getAccountBalance() + acc.getAccountBalance() * fixedInterestRate);
            acc.setAccountBalance(acc.getAccountBalance() - 500);
            acc.setAccountBalance(acc.getAccountBalance() - acc.getPaidLoan()*loanInterestRate);
        }
    }

    // Account Section Work
    public void createAccount(String name, String accountType, double initialDiposit){
        int []idx = getAccountIndex(name);
        if(idx[0]==1 || idx[0]==2 || idx[0]==3){
            System.out.println("Account Already Exists");
        }
        else{
            if (accountType.equals("savings")){
                Savings temp = new Savings(name, initialDiposit);
                savingsAccounts.add(temp);
            }
            else if (accountType.equals("student")){
                Student temp = new Student(name, initialDiposit);
                studentAccounts.add(temp);
            }
            else {
                if (initialDiposit>=100000){
                    FixedDiposit temp = new FixedDiposit(name, initialDiposit);
                    fixedAccounts.add(temp);
                }
                else {
                    System.out.println("Invalid Initial Diposit");
                }
            }
        }
    }
    public int[] getAccountIndex(String accountName){
        String account = "none";
        int[] index = new int[2];
        index[0] = -1;
        index[1] = -1;
        if (account.equals("none")){
            for (int i=0; i<savingsAccounts.size(); i++){
                if (savingsAccounts.get(i).getAccountName().equals(accountName)){
                    account = accountName;
                    index[0] = 1;
                    index[1] = i;
                    break;
                }
            }
        }
        if (account.equals("none")){
            for (int i=0; i<studentAccounts.size(); i++){
                if (studentAccounts.get(i).getAccountName().equals(accountName)){
                    account = accountName;
                    index[0] = 2;
                    index[1] = i;
                    break;
                }
            }
        }
        if (account.equals("none")){
            for (int i=0; i<fixedAccounts.size(); i++){
                if (fixedAccounts.get(i).getAccountName().equals(accountName)){
                    account = accountName;
                    index[0] = 3;
                    index[1] = i;
                    break;
                }
            }
        }
        return index;
    }
    public void loginAccount(String accountName){
        int[] idx = getAccountIndex(accountName);
        if(idx[0]==1 || idx[0]==2 || idx[0]==3){
            System.out.println("Welcome Back " + accountName);
        }
    }
    public void depositMoney(String accountName, double amount){
        int[] index = getAccountIndex(accountName);
        if (index[0]==1){
            savingsAccounts.get(index[1]).dipositMoney(amount);
        }
        else if (index[0]==2){
            studentAccounts.get(index[1]).dipositMoney(amount);
        }
        else{
            fixedAccounts.get(index[1]).dipositMoney(amount);
        }
    }
    public void withdrawMoney(String accountName, double amount){
        int[] index = getAccountIndex(accountName);
        if (index[0]==1){
            savingsAccounts.get(index[1]).withdrawMoney(amount);
        }
        else if (index[0]==2){
            studentAccounts.get(index[1]).withdrawMoney(amount);
        }
        else{
            if (clock>=1){
                fixedAccounts.get(index[1]).withdrawMoney(amount);
            }
            else
                System.out.println("Wait for Maturity Period");
        }
    }
    public void checkBalance(String accountName){
        int[] index = getAccountIndex(accountName);
        if (index[0]==1){
            double balance = savingsAccounts.get(index[1]).getAccountBalance();
            System.out.println("Current Balance " + balance + " , Loan " + savingsAccounts.get(index[1]).getPaidLoan());
        }
        else if (index[0]==2){
            double balance = studentAccounts.get(index[1]).getAccountBalance();
            System.out.println("Current Balance " + balance + " , Loan " + studentAccounts.get(index[1]).getPaidLoan());
        }
        else if (index[0]==3){
            double balance = fixedAccounts.get(index[1]).getAccountBalance();
            System.out.println("Current Balance " + balance + " , Loan " + fixedAccounts.get(index[1]).getPaidLoan());
        }
        else{
            System.out.println("Something Invalid");
        }
    }
    public void requestLoan(String accountName, double amount){
        int[] index = getAccountIndex(accountName);
        if (index[0]==1){
            savingsAccounts.get(index[1]).requestLoan(amount, internalFund);
        }
        else if (index[0]==2){
            studentAccounts.get(index[1]).requestLoan(amount, internalFund);
        }
        else{
            fixedAccounts.get(index[1]).requestLoan(amount, internalFund);
        }
    }

    //Employee Section Work
    public void lookUp(String accountName, String who){
        int[] index = getAccountIndex(accountName);
        double ans = O1.lookUp(index, savingsAccounts, studentAccounts, fixedAccounts);
        System.out.println("Account Balance of "+ accountName + " is " +ans);
    }

    public void viewLoan(String who){
        if (who.equals("MD")){
            System.out.println("Pending Loans : ");
            MD.viewLoan(savingsAccounts, studentAccounts, fixedAccounts);
        }
        else if(who.charAt(0) == 'O'){
            System.out.println("Pending Loans : ");
            O1.viewLoan(savingsAccounts, studentAccounts, fixedAccounts);
        }
        else if (who.charAt(0) == 'C'){
            System.out.println("Pending Loans : ");
            C1.viewLoan(savingsAccounts, studentAccounts, fixedAccounts);
        }
        else {
            System.out.println("You don’t have permission for this operation");
        }
    }
    public void approveLoan(String accountName, String who){
        int[] index = getAccountIndex(accountName);
        if (who.equals("MD"))
            internalFund -= MD.approveLoan(index, savingsAccounts, studentAccounts, fixedAccounts);
        else if(who.charAt(0) == 'O')
            internalFund -= O1.approveLoan(index, savingsAccounts, studentAccounts, fixedAccounts);
        else if (who.charAt(0) == 'C')
            internalFund -= C1.approveLoan(index, savingsAccounts, studentAccounts, fixedAccounts);
        else {
            System.out.println("You don’t have permission for this operation");
        }
    }
    public void approveAllLoan(String who){
        if (who.equals("MD"))
            internalFund = internalFund - MD.approveAllLoan(savingsAccounts, studentAccounts, fixedAccounts);
        else if(who.charAt(0) == 'O')
            internalFund = internalFund - O1.approveAllLoan(savingsAccounts, studentAccounts, fixedAccounts);
        else if (who.charAt(0) == 'C')
            internalFund = internalFund - C1.approveAllLoan(savingsAccounts, studentAccounts, fixedAccounts);
        else {
            System.out.println("You don’t have permission for this operation");
        }
    }
    public void changeInterestRate(String accountType, double rate, String who){
        if (who.equals("MD")) {
            double []newInterestRate = MD.changeInterestRate(accountType, rate);
            if (newInterestRate[0] == 1){
                savingsInterestRate = newInterestRate[1];
            }
            else if (newInterestRate[0] == 2){
                studentInterestRate = newInterestRate[1];
            }
            else {
                fixedInterestRate = newInterestRate[1];
            }
        }
    }
    public void seeInitialFund(String who){
        if (who.equals("MD"))
            MD.seeInternalFund(internalFund);
        else if(who.charAt(0) == 'O')
            O1.seeInternalFund(internalFund);
        else if (who.charAt(0) == 'C')
            C1.seeInternalFund(internalFund);
        else
            System.out.println("You don’t have permission for this operation");
    }
}

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(1000000, 0);
        Scanner sc = new Scanner(System.in);
        String current = "none";
        while(sc.hasNextLine()){
            String command = sc.nextLine();
            String[] commands = command.split(" ");
            String accountName;
            if (commands[0].toString().equals("Create")){
                accountName = commands[1].toString();
                bank.createAccount(accountName, commands[2].toLowerCase(), Double.parseDouble(commands[3].toString()));
                current = accountName;
            }

            if (commands[0].equals("Open")) {
                current = commands[1];
                bank.loginAccount(current);
            }

            if (commands[0].toString().equals("Diposit")){
                double dipositAmount = Double.parseDouble(commands[1].toString());
                bank.depositMoney(current, dipositAmount);
                bank.checkBalance(current.toString());
            }

            if (commands[0].toString().equals("Withdraw")){
                double withdrawAmount = Double.parseDouble(commands[1].toString());
                bank.withdrawMoney(current, withdrawAmount);
                bank.checkBalance(current.toString());
            }

            if (commands[0].toString().equals("Query")){
                bank.checkBalance(current.toString());
            }

            if (commands[0].toString().equals("Request")){
                double requestLoan = Double.parseDouble(commands[1].toString());
                bank.requestLoan(current, requestLoan);
                bank.checkBalance(current.toString());
            }

            if (current.equals("O1") || current.equals("O2") || current.equals("C1") || current.equals("C2") || current.equals("C3")  || current.equals("C4")  || current.equals("C5") || current.equals("MD")){

                if(!current.equals("none"))
                    System.out.println(current + " Active");
                bank.viewLoan(current);
                if (commands[0].toString().equals("Approve") && commands[1].equals("Loan")){
                    bank.approveAllLoan(current);
                }
                else if (commands[0].toString().equals("Approve")){
                    bank.approveLoan(commands[1], current);
                }
                else if (commands[0].toString().equals("Change")){
                    bank.changeInterestRate(commands[1].toLowerCase(), Double.parseDouble(commands[2].toString()), current);
                }
                else if (commands[0].toString().equals("Lookup")){
                    bank.lookUp(commands[1], current);
                }
                else if (commands[0].equals("See")){
                    bank.seeInitialFund(current);
                }
            }

            if (commands[0].equals("Close")){
                System.out.println("User Logged Out");
                current = "none";
            }

            if (commands[0].equals("INC")){
                bank.updateClock();
            }
        }
    }
}

/*
Syntax to use :
    Account Holder:
        Create yourName accountType initialDiposit
        Create kkp Student 10000
        Close
        Open kkp
        Query
        Diposit 1000
        Withdraw 1000
        Request 1000
        Close

    Employee:
        Open MD / Open O1 / Open O2 / Open C1 / Open C2 .... C5
        Lookup accountName
        Approve Loan  (Approve All Loans)
        Approve accountName (Approve by name)
        See (Internal Fund)
        Change accoutType interest
        INC (yearClock++)
        Close
 */