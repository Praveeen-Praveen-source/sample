package com.example.BankProject.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private long account_id;
private String name;
private double balance;
private String ifsc_code;


@ManyToOne
@JoinColumn
Branch branch;

@OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
Customer customer;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public long getAccount_id() {
	return account_id;
}

public void setAccount_id(long account_id) {
	this.account_id = account_id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public String getIfsc_code() {
	return ifsc_code;
}

public void setIfsc_code(String ifsc_code) {
	this.ifsc_code = ifsc_code;
}

public Branch getBranch() {
	return branch;
}

public void setBranch(Branch branch) {
	this.branch = branch;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}





}
