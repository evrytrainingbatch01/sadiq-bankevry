package com.evry.bank.dtointerfaces;

public interface EvCustomer {
	
	public int addMoney(int addmoney,int accountNum);
	public int viewMoney(int accountNum);
	public void sendMoney(int acnum,int benifituary,int amt);
	public int withdrawMoney(int ac,int amt);
	public void askForLoan(int amt,String id);

}
