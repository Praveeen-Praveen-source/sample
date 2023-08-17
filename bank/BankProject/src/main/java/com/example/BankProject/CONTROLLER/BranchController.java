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

import com.example.BankProject.DAO.BranchDao;
import com.example.BankProject.DTO.Branch;


@RestController
@RequestMapping("/branch")

public class BranchController 
{
		@Autowired
	BranchDao branchdao;

	@PostMapping
	public ResponseEntity<Branch> addBranch(@RequestBody Branch bran,int id)
	{
		Branch b=branchdao.addBranch(bran, id);
		return ResponseEntity.ok(b);    
		
		    
	}

	@GetMapping
	public ResponseEntity<List<Branch>> findAll()
	{
		List<Branch> list=branchdao.FetchAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/byid")
	public ResponseEntity<Branch> searchByID(@RequestParam int id)
	{
		Branch branch =branchdao.searchById(id);
		if(branch!=null)
		{
			return ResponseEntity.ok(branch);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<Branch> updateBranch(@RequestParam int id,String name,String location)
	{
		Branch branch1=branchdao.updateBranch(id, name,location);
		if(branch1!=null)
		{
			return ResponseEntity.ok(branch1);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteBank(@RequestParam int id)
	{
		int a=branchdao.removeBranch(id);
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


