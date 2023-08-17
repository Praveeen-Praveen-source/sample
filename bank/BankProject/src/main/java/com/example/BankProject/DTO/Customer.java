package com.example.BankProject.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private long customer_id;
private String name;
private String address;
private long phone_no;

@OneToOne
@JoinColumn
Account account;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public long getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(long customer_id) {
	this.customer_id = customer_id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public long getPhone_no() {
	return phone_no;
}

public void setPhone_no(long phone_no) {
	this.phone_no = phone_no;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}


}
