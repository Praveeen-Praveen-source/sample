package com.example.BankProject.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BankProject.DTO.Account;
import com.example.BankProject.DTO.Branch;
import com.example.BankProject.REPOSITORY.AccountRepository;
import com.example.BankProject.REPOSITORY.BranchRepository;

@Repository
public class AccountDao 
{
@Autowired
AccountRepository repo;

@Autowired
BranchDao branch;


public Account addAccount(Account account,int id)
{
	Branch b=branch.searchById(id);
	if(b!=null)
	{
		List<Account> list=new ArrayList<>();
		b.setAccount(list);
		return repo.save(account);
	}
	return null;
}

public Account searchById(int id)
{
	Optional<Account> opt=repo.findById(id);
	if(opt.isPresent())
	{
		return opt.get();
	}
	return null;
}

public List<Account> FetchAll()
{
	return repo.findAll();
}

public int removeAccount(int id)
{
	Account acc=searchById(id);
	if(acc!=null)
	{
		repo.deleteById(id);
		return 1;
	}
	return 0;
}

public Account updateAccount(int id,long account_id,String name,String ifsc)
{
	Account acc=searchById(id);
	if(acc!=null)
	{
		acc.setAccount_id(account_id);
		acc.setName(name);
		acc.setIfsc_code(ifsc);
		repo.save(acc);
		return acc;
		
	}
	return null;
}

}
