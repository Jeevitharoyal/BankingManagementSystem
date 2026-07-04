package com.bankingsystem;
import java.util.ArrayList;
import java.io.Serializable;


public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountNumber;
	private String accountHolderName;
	private String password;
	private double balance;
	private ArrayList<Transaction> transactions = new ArrayList<>();
	
	public Account(int accountNumber,String accountHolderName, String password, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.password = password;
		this.balance = balance;
		
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public String getPassword() {
		return password;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		if(amount > 0) {
			balance = balance + amount;
			transactions.add(new Transaction("Deposit",amount));
			System.out.println("Rs." + amount + " deposited successfully.");
		}
		else {
			System.out.println("Invalid amount.");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance = balance - amount;
			transactions.add(new Transaction("Withdraw", amount));
			System.out.println("Rs." + amount + " withdrawn successfully.");
		}
		else {
			System.out.println("Insufficient balance or invalid amount.");
		}
	}
	
	@Override
	public String toString() {
		return "Account Number : " + accountNumber + 
				"\nAccount Holder : " + accountHolderName +
				"\nBalance        :" + balance;
	}
	
	public void showTransactions() {
		if(transactions.isEmpty()) {
			System.out.println("No transactions found.");
			return;
		}
		System.out.println("\n======Transaction History ======");
		for(Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}
	

}
