package com.example.BankProject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankProject.DTO.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>
{

}
