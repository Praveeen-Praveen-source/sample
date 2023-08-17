package com.example.BankProject.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankProject.DAO.BankDao;
import com.example.BankProject.DTO.Bank;

@RestController
@RequestMapping("/bank")
public class BankController 
{
@Autowired
BankDao bankdao;

@PostMapping
public ResponseEntity<Bank> addBank(@RequestBody Bank ban)
{
	Bank b=bankdao.addBank(ban);
	return ResponseEntity.ok(b);    
	
	    
}

@GetMapping
public ResponseEntity<List<Bank>> findAll()
{
	List<Bank> list=bankdao.searchAll();
	return ResponseEntity.ok(list);
}

@GetMapping("/byid")
public ResponseEntity<Bank> searchByID(@RequestParam int id)
{
	Bank ban =bankdao.searchById(id);
	if(ban!=null)
	{
		return ResponseEntity.ok(ban);
	}
	else
	{
		return ResponseEntity.notFound().build();
	}
}

@PutMapping
public ResponseEntity<Bank> updateBank(@RequestParam int id,String name)
{
	Bank bank1=bankdao.updateBank(id, name);
	if(bank1!=null)
	{
		return ResponseEntity.ok(bank1);
	}
	return ResponseEntity.notFound().build();
}

@DeleteMapping
public ResponseEntity<Void> deleteBank(@RequestParam int id)
{
	int a=bankdao.removeById(id);
	if(a==1)
	{
		return ResponseEntity.ok().build();
	}
	else
	{
		return ResponseEntity.notFound().build();
	}
}
}
