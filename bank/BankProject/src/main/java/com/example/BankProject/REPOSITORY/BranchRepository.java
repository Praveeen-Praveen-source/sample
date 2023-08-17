package com.example.BankProject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankProject.DTO.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>
{

}
