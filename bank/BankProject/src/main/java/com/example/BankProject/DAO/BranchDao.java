package com.example.BankProject.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BankProject.DTO.Bank;
import com.example.BankProject.DTO.Branch;
import com.example.BankProject.REPOSITORY.BranchRepository;

@Repository
public class BranchDao 
{
	@Autowired
	BranchRepository repo;
	
	@Autowired
	BankDao bank;
	
	public Branch addBranch(Branch branch,int id)
	{
		Bank b=bank.searchById(id);
		if(b!=null)
		{
			List<Branch> list=new ArrayList<>();
			b.setBranches(list);
			return repo.save(branch);
		}
		return null;
	}
	
	
	
	public Branch searchById(int id)
	{
		Optional<Branch> opt=repo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
	}
	
	public List<Branch> FetchAll()
	{
		return repo.findAll();
	}
	
	public int removeBranch(int id)
	{
		Branch b=searchById(id);
		if(b!=null)
		{
			repo.deleteById(id);
			return 1;
		}
		return 0;
	}

	public Branch updateBranch(int id,String name,String location)
	{
		Branch b=searchById(id);
		if(b!=null)
		{
			b.setName(name);
			b.setLocation(location);
			repo.save(b);
			return b;
		}
		return null;
	}
}
