package com.nordstrom.customer.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

	String accountId;
	String bankAccountNumber;
	String bankToken;

	@XmlAttribute(name = "accountId")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@XmlAttribute(name = "bankAccountNumber")
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@XmlAttribute(name = "bankToken")
	public String getBankToken() {
		return bankToken;
	}

	public void setBankToken(String bankToken) {
		this.bankToken = bankToken;
	}

}
