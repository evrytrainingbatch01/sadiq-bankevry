package com.evry.bank.dao;

import java.util.Scanner;

import com.evry.bank.dtoimpl.EvCustomerImpl;

public class CustomerDAO {
	
	public void callCustomer() {
		int choice;
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Menu");
		System.out.println("press 1 to add money");
		System.out.println("press 2 to view money");
		System.out.println("press 3 to send money");
		System.out.println("press 4 to withdraw money");
		System.out.println("press 5 to ask for loan");
		
		choice=scanner.nextInt();
		
		EvCustomerImpl customerImpl = new EvCustomerImpl();
		//AccountInfo accountInfo=new AccountInfo();
		
		switch(choice) {
		case 1 : {
			System.out.println("enter your account details..");
			System.out.println("enter account number");
			int acnum=scanner.nextInt();
			
				System.out.println("enter the amount");
				int amt=scanner.nextInt();
				if(amt>0) {
				customerImpl.addMoney(amt,acnum);
				}
				else {
					System.out.println("amount is not sufficient");	
				}
			
		}
		break;
		
		case 2 : {
			System.out.println("enter your account details..");
			System.out.println("enter account number");
			int acnum=scanner.nextInt();
			customerImpl.viewMoney(acnum);
			
		}
		break;
		
		case 3 : {
			System.out.println("enter your account detalils..");
			System.out.println("enter account number");
			int acnum=scanner.nextInt();
			System.out.println("enter benifituary account number");
			int benifituary=scanner.nextInt();
			System.out.println("enter the amount you want to send");
			int amt=scanner.nextInt();
			customerImpl.sendMoney(acnum,benifituary,amt);
			
		}
		break;
		
		case 4 : {
			System.out.println("enter your account number");
			int acnum = scanner.nextInt();
			System.out.println("enter the amount");
			int amt=scanner.nextInt();
			customerImpl.withdrawMoney(acnum,amt);
		}
		break;
		
		case 5: {
			System.out.println("enter the id number");
			String id=scanner.next();
			System.out.println("enter the loan amount");
			int amt=scanner.nextInt();
			customerImpl.askForLoan(amt,id);
		}
		break;
			
		}
	}

}
