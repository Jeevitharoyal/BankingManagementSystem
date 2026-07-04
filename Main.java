package com.bankingsystem;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		while(true) {
			System.out.println("\n======= Banking Management System =======");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Display All Accounts");
			System.out.println("4. Deposit Money");
			System.out.println("5. Withdraw Money");
			System.out.println("6. Check Balance");
			System.out.println("7. View Transaction History");
			System.out.println("8. Transfer Money");
			System.out.println("9. Delete Account");
			System.out.println("10. Save Accounts");
			System.out.println("11. Exit");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter Account Number: ");
				int accountNumber = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Account Holder Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Password: ");
				String password = sc.nextLine();
				System.out.print("Enter Initial Balance: ");
				double balance = sc.nextDouble();
				Account account = new Account(accountNumber, name, password, balance);
				bank.createAccount(account);
				break;
			case 2:
				System.out.print("Enter Account Number: ");
				int loginAccountNumber = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Password: ");
				String loginPassword = sc.nextLine();
				Account loggedInAccount = bank.login(loginAccountNumber, loginPassword);
				if(loggedInAccount != null) {
					System.out.println("Login Successfull!");
					System.out.println("Welcome " + loggedInAccount.getAccountHolderName());
					
				}
				else {
					System.out.println("Invalid Account Number or Password!");
				}
				break;
			case 3:
				bank.displayAllAccounts();
				break;
			case 4:
				System.out.print("Enter Account Number: ");
				int depAccNo = sc.nextInt();
				System.out.print("Enter Deposit Amount: ");
				double depAmount = sc.nextDouble();
				
				Account depAccount = bank.searchAccount(depAccNo);
				if(depAccount != null) {
					depAccount.deposit(depAmount);
				}
				else {
					System.out.println("Account not found!");
				}
				break;
			case 5:
				System.out.print("Enter Account Number: ");
				int withAccNo = sc.nextInt();
				System.out.print("Enter Withdraw Amount: ");
				double withAmount = sc.nextDouble();
				
				Account withAccount = bank.searchAccount(withAccNo);
				if(withAccount != null) {
					withAccount.withdraw(withAmount);
				}
				else {
					System.out.println("Account not found!");
				}
				break;
			case 6:
				System.out.print("Enter Account Number: ");
				int balAccNo = sc.nextInt();
				Account balAccount = bank.searchAccount(balAccNo);
				if(balAccount != null) {
					System.out.println("Current Balance: Rs." + balAccount.getBalance());
				}
				else {
					System.out.println("Account not found!");
				}
				break;
			case 7:
				System.out.print("Enter Account Number: ");
				int transAccNo = sc.nextInt();
				Account transAccount = bank.searchAccount(transAccNo);
				if(transAccount != null) {
					transAccount.showTransactions();
				}
				else {
					System.out.println("Account not found!");
				}
				break;
			case 8:
				System.out.print("Enter Sender Account Number: ");
				int senderAccNo = sc.nextInt();
				System.out.print("Enter Receiver Account Number: ");
				int receiverAccNo = sc.nextInt();
				System.out.print("Enter Amount to Transfer: ");
				double transferAmount = sc.nextDouble();
				bank.transferMoney(senderAccNo, receiverAccNo, transferAmount);
				break;
			case 9:
				System.out.print("Enter Account Number to Delete: ");
				int deleteAccNo = sc.nextInt();
				bank.deleteAccount(deleteAccNo);
				break;
			case 10:
				FileManager.saveAccounts(bank);
				break;
						
			case 11:
				System.out.println("Thank you for using Banking Management System.");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid Choice!");
			}
		}

	}

}
