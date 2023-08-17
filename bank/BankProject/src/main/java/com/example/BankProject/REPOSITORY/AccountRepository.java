package com.example.BankProject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankProject.DTO.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>
{

}
