package com.company;

class Account{
    private String accountName;
    private int accountBalance;

    public Account(String accountName, int accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

}

class Savings extends Account{
    public Savings(String accountName, int accountBalance) {
        super(accountName, accountBalance);
    }

    public void dipositMoney(int amount){
        setAccountBalance(getAccountBalance() + amount);
    }
}

class Student extends Account{
    public Student(String accountName, int accountBalance) {
        super(accountName, accountBalance);
    }

    public void dipositMoney(int amount){
        setAccountBalance(getAccountBalance() + amount);
    }
}

class FixedDiposit extends Account{
    public FixedDiposit(String accountName, int accountBalance) {
        super(accountName, accountBalance);
    }

    public void dipositMoney(int amount){
        if (amount > 50000) {
            setAccountBalance(getAccountBalance() + amount);
        }
        else {
            System.out.println("Amount should be greater than 50000$");
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");

        Student kkp = new Student("kawshik", 1000);
        System.out.println(kkp.getAccountName());
        System.out.println(kkp.getAccountBalance());
    }
}
