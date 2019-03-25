package com.evry.bank.dtointerfaces;

import com.evry.bank.dto.EvCustomerDTO;

public interface EvAdmin {
	
	public void addCustomer(EvCustomerDTO dto);
	public void deleteCustomer(String id);
	public void approveTransaction(String id);
	public void approveLoans(String id);

}
