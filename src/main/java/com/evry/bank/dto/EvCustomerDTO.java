package com.evry.bank.dto;

import java.io.Serializable;

import com.evry.bank.account.AccountInfo;

public class EvCustomerDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1910597833575515747L;
	
	private String id;
	private String firstname;
	private String lastName;
	private String city;
	private String country;
	private long mobileNumber;
	private String emailId;
	
	private AccountInfo accountInfo;
	
	public EvCustomerDTO() {
		
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EvCustomerDTO [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", city=" + city
				+ ", country=" + country + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
	

	
}
