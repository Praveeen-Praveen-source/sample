package com.example.BankProject.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.aspectj.apache.bcel.generic.BranchHandle;

@Entity
public class Bank 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;

@OneToMany
@JoinColumn
List<Branch> Branches;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Branch> getBranches() {
	return Branches;
}

public void setBranches(List<Branch> branches) {
	Branches = branches;
}


}
