package com.evry.bank.dtoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evry.bank.connection.MysqlConnection;
import com.evry.bank.dtointerfaces.EvCustomer;

public class EvCustomerImpl implements EvCustomer{

	@Override
	public int addMoney(int addmoney,int accountNum)  {
		Connection connection = MysqlConnection.getConnection();
		
		try {
			System.out.println("update customer set balance=balance + "+addmoney+" where acnumber = "+accountNum);
			
			PreparedStatement addingMoney = connection.prepareStatement("update customer set balance=balance + "+addmoney+" where acnumber = "+accountNum);
			addingMoney.executeUpdate();
				
				System.out.println("Money added successfully to your account.");
				
				Statement stmt=connection.createStatement();
				ResultSet rs=stmt.executeQuery("select balance from customer where acnumber = "+accountNum);
				while(rs.next()) {
					System.out.println("Current balance in your account is "+rs.getInt(1));
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return addmoney;
	}

	@Override
	public int viewMoney(int ac) {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery("select balance from customer where acnumber=" +ac);
			while(rs.next()) {
			System.out.println("Available balance is "+rs.getString(1));
			}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void sendMoney(int acnum, int benifituary, int amt) {
		// TODO Auto-generated method stub
		Connection connection =MysqlConnection.getConnection();
		try {
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select balance from customer where acnumber ="+acnum);
			while(rs.next()) {
				if(rs.getInt(1)>amt) {
					PreparedStatement pstmt=connection.prepareStatement("update customer set balance=balance + "+amt+" where acnumber= "+benifituary);
					pstmt.executeUpdate();
					System.out.println("Money sent to "+benifituary+" successfully");
					PreparedStatement pstmt2=connection.prepareStatement("update customer set balance=balance -"+amt+" where acnumber= "+acnum);
					pstmt2.executeUpdate();
					System.out.println(amt +" has been deducted from your account "+acnum);
				}
				else 
					System.out.println("Due to insufficient balance you cannot perform this transaction.Thank You!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int withdrawMoney(int ac,int amt) {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		
		try {
			 Statement stmt2=connection.createStatement();
			 ResultSet rs=stmt2.executeQuery("select balance from customer where acnumber = "+ac);
			while(rs.next()) {
				int oldbal=rs.getInt(1);
				if(oldbal>=amt) {
					PreparedStatement withdraw=connection.prepareStatement("update customer set balance=balance-"+amt);
					withdraw.executeUpdate();
					System.out.println("Amount withdrawed successfully..");
					Statement stmt3=connection.createStatement();
					ResultSet rs2=stmt3.executeQuery("select balance from customer where acnumber = "+ac);
					while(rs2.next()) {
						System.out.println("Current balance in your account is " + rs2.getInt(1));
					}
				}
				else
					System.out.println("Insufficient funds..");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public void askForLoan(int amt,String id) {
		// TODO Auto-generated method stub
		//System.out.println("Amount that account number "+ac+" want to apply for loan "+amt);
		Connection connection = MysqlConnection.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("select id from customer where id=?");
			pstmt.setString(1, id);
			ResultSet a=pstmt.executeQuery();
			if(a.next()) {
				System.out.println("Requesting loan by id "+id+" "+ "and the amount is "+amt);
			}
			else
				System.out.println("there is no such customer to proceed the transaction..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
