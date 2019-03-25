package com.evry.bank.dtoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evry.bank.connection.MysqlConnection;
import com.evry.bank.dto.EvAdminDTO;
import com.evry.bank.dto.EvCustomerDTO;
import com.evry.bank.dtointerfaces.EvAdmin;

public class EvAdminImpl implements EvAdmin {
	
	EvCustomerDTO dto=new EvCustomerDTO();
	EvAdminDTO adminDto = new EvAdminDTO();
	
	@Override
	public void addCustomer(EvCustomerDTO dto) {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement creating=connection.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
			creating.setString(1, dto.getId());
			creating.setString(2, dto.getFirstname());
			creating.setString(3, dto.getLastName());

			creating.setString(4, dto.getCity());
			creating.setString(5, dto.getCountry());
			creating.setLong(6, dto.getMobileNumber());
			creating.setString(7, dto.getEmailId());
			creating.setInt(8, dto.getAccountInfo().getAccountNumber());
			creating.setDouble(9, dto.getAccountInfo().getBalance());
			
			creating.execute();
			
			System.out.println("---Added customer successfully---");

			
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
	}

	@Override
	public void deleteCustomer(String id) {
		// TODO Auto-generated method stub
		
		Connection connection = MysqlConnection.getConnection();
		
		try {
			PreparedStatement deleteCustomer= connection.prepareStatement("delete from customer where id="+id);
			boolean a=deleteCustomer.execute();
			if(a==true)
			System.out.println("--- deleted customer successfully ---");
			else
				System.out.println("entered customer id is not exist.");
			
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
		
	}

	@Override
	public void approveTransaction(String id) {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement("select id from customer where id=?");
			pstmt.setString(1, id);
			ResultSet a=pstmt.executeQuery();
			if(a.next()) {
				System.out.println("Transaction approved for id "+id);
			}
			else
				System.out.println("there is no such customer to proceed the transaction..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		


	@Override
	public void approveLoans(String id) {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement pstmt=connection.prepareStatement("select id from customer where id=?");
			pstmt.setString(1, id);
			ResultSet a=pstmt.executeQuery();
			if(a.next()) {
				System.out.println("Loan approved for id "+id);
			}
			else
				System.out.println("there is no such customer..");
			
				
			/*Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select id from customer where id="+id);
			
			while(rs.next()==true) {
				System.out.println("Loan approved for id "+id);
			}*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*@Override
	public void viewAllCustomers() {
		// TODO Auto-generated method stub
		Connection connection = MysqlConnection.getConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from customer");
			while(rs.next()) {
System.out.println("Customer Id " + rs.getInt(1) +" First Name "+rs.getInt(2)+
" Last name "+rs.getInt(3)+" city "+rs.getInt(4)+" country "+rs.getInt(5)+
" Mobile Number "+rs.getInt(6)+" Email Id "+rs.getInt(7)+" Account No "+rs.getInt(8)+
" balance "+rs.getInt(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
	

}
