package com.example.BankProject.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BankProject.DTO.Account;
import com.example.BankProject.DTO.Customer;
import com.example.BankProject.REPOSITORY.CustomerRepository;

@Repository
public class CustomerDao 
{
@Autowired
CustomerRepository repo;

@Autowired
AccountDao account;

public Customer addCustomer(Customer customer,int id)
{
	Account a=account.searchById(id);
	if(a!=null)
	{
		List<Customer> list=new ArrayList<>();
		a.setCustomer(customer);
		return repo.save(customer);
	}
	return null;
}

public Customer searchById(int id)
{
	Optional<Customer> opt=repo.findById(id);
	if(opt.isPresent())
	{
		return opt.get();
	}
	return null;
}

public List<Customer> FetchAll()
{
	return repo.findAll();
}

public int reomoveCustomer(int id)
{
	Customer cus=searchById(id);
	if(cus!=null)
	{
		repo.deleteById(id);
		return 1;
	}
	return 0;
	
}

public Customer UpdateCustomer(int id,long customer_id,String name,String address,long phone_no)
{
	Customer cus=searchById(id);
	if(cus!=null)
	{
		cus.setId(id);
		cus.setCustomer_id(customer_id);
		cus.setName(name);
		cus.setAddress(address);
		cus.setPhone_no(phone_no);
		repo.save(cus);
		return cus;
	}
	return null;
}

}
