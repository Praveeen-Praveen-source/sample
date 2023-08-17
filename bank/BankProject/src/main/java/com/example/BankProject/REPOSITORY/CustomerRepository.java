package com.example.BankProject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankProject.DTO.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>
{

}
