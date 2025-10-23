package com.example.demo.repository;
import com.example.demo.entity.Contract;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface ContractRepo extends JpaRepository<Contract, Long> { 
    Page<Contract> findByStatus(String status, Pageable pageable);
    Optional<Contract> findByContractNumber(String contractNumber);
}