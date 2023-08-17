package com.example.BankProject.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BankProject.DTO.Bank;
import com.example.BankProject.REPOSITORY.BankRepository;

@Repository
public class BankDao 
{
@Autowired
BankRepository repo;


public Bank addBank(Bank bank)
{
	return repo.save(bank);
	
}

public Bank searchById(int id)
{
	Optional<Bank> opt= repo.findById(id);
	if(opt.isPresent())
	{
		return opt.get();
	}
	return null;
}

public List<Bank> searchAll()
{
	return repo.findAll();
}

public int removeById(int id)
{
	Bank b=searchById(id);
	
	if(b!=null)
	{
		repo.deleteById(id);
		return 1;
	}
	else
	{
		return 0;
	}
}

public Bank updateBank(int id,String name)
{
	Bank b=searchById(id);
	if(b!=null)
	{
		b.setName(name);
		repo.save(b);
		return b;
	}
	return null;
}

}

