package com.bankingsystem;
import java.io.*;

public class FileManager {
	public static void saveAccounts(Bank bank) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accounts.dat"));
			out.writeObject(bank);
			out.close();
			System.out.println("accounts saved successfully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
