package com.evry.bank.mainapp;

import java.util.Scanner;

import com.evry.bank.dao.AdminDAO;
import com.evry.bank.dao.CustomerDAO;

public class MainApplication {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		int selectType;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("press 1 if you are Admin");
		System.out.println("press 2 if you are Customer");
		selectType=scanner.nextInt();
		switch (selectType) {
		case 1: {
			System.out.println("enter your admin id");
			int id=scanner.nextInt();
			System.out.println("enter your admin password");
		String password	=scanner.next();
		
			new AdminDAO().callAdmin(id,password);
			
		}
			break;
			
		case 2: {
			new CustomerDAO().callCustomer();
		}

		default:
			break;
		}
		

	}

}
