package com.bankingsystem;
import java.util.ArrayList;
import java.io.Serializable;

public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Account> accounts = new ArrayList<>();
	
	public void createAccount(Account account) {
		accounts.add(account);
		System.out.println("Account created successfully.");
	}
	
	public Account searchAccount(int accountNumber) {
		for(Account account : accounts) {
			if(account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}
	
	public Account login(int accountNumber, String password) {
		Account account = searchAccount(accountNumber);
		if(account != null && account.getPassword().equals(password)) {
			return account;
		}
		return null;
	}
	
	public void displayAllAccounts() {
		if(accounts.isEmpty()) {
			System.out.println("No accounts found.");
			return;
		}
		for(Account account : accounts) {
			System.out.println(account);
			System.out.println("-----------------------------------------------------");
		}
		
	}
	
	public void transferMoney(int fromAccNo, int toAccNo, double amount) {
		Account sender = searchAccount(fromAccNo);
		Account receiver = searchAccount(toAccNo);
		if(sender == null || receiver == null) {
			System.out.println("One or both accounts not found!");
			return;
		}
		if(sender.getBalance() >= amount && amount > 0) {
			sender.withdraw(amount);
			receiver.deposit(amount);
			System.out.println("Money transferred successfully.");
		}
		else {
			System.out.println("Insufficient balance!");
		}
	}
	public void deleteAccount(int accountNumber) {
		Account account = searchAccount(accountNumber);
		if(account != null) {
			accounts.remove(account);
			System.out.println("Account deleted successfully.");
		}
		else {
			System.out.println("Account not found.");
		}
	}
	

	

}
