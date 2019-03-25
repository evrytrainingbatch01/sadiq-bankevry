package com.evry.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.evry.bank.account.AccountInfo;
import com.evry.bank.connection.MysqlConnection;
import com.evry.bank.dto.EvCustomerDTO;
import com.evry.bank.dtoimpl.EvAdminImpl;

public class AdminDAO {

	public void callAdmin(int id, String pwd) throws SQLException {

		Connection connection = MysqlConnection.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where id=? && password=?");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, pwd);
			rs = preparedStatement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rs.next()) {

			int choice;

			// EvAdmindDTO admindDTO=new EvAdmindDTO();

			Scanner sc = new Scanner(System.in);
			System.out.println("Menu");
			System.out.println("press 1 to add customer");
			System.out.println("press 2 to delete customer");
			System.out.println("press 3 to approve loans");
			System.out.println("press 4 to approve transactions");


			choice = sc.nextInt();

			EvCustomerDTO dto = new EvCustomerDTO();
			EvAdminImpl impl = new EvAdminImpl();

			switch (choice) {

			case 1: {
				System.out.println("Enter customer details..");
				System.out.println("enter id");
				dto.setId(sc.next());
				System.out.println("enter firstname");
				dto.setFirstname(sc.next());
				System.out.println("enter lastname");
				dto.setLastName(sc.next());
				System.out.println("enter city");
				dto.setCity(sc.next());
				System.out.println("enter country");
				dto.setCountry(sc.next());
				System.out.println("enter phone");
				dto.setMobileNumber(sc.nextLong());
				System.out.println("enter emailid");
				dto.setEmailId(sc.next());
				AccountInfo account = new AccountInfo();
				dto.setAccountInfo(account);
				impl.addCustomer(dto);

			}
				break;

			case 2: {
				System.out.println("enter the id of the customer you want to delete");
				dto.setId(sc.next());
				impl.deleteCustomer(dto.getId());

			}
				break;

			case 3: {
				System.out.println("enter the id of the customer to approve loan..");
				dto.setId(sc.next());
				impl.approveLoans(dto.getId());
			}
				break;

			case 4: {
				System.out.println("enter the id of customer to approve transaction..");
				dto.setId(sc.next());
				impl.approveTransaction(dto.getId());
			}
				break;
				
			}
		}else {
			System.out.println("Invalid Credentials Try again");
		}

	}

}
