package com.evry.bank.account;

import java.util.Random;

public class AccountInfo {
	
	private int accountNumber=new Random().nextInt(1000);
	private double balance;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
