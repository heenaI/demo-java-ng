package com.example.demo.service;
import com.example.demo.dto.ContractCreate;
import com.example.demo.dto.ContractResponse;
import com.example.demo.repository.ContractRepo;
import com.example.demo.entity.Contract;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

@Service

public class ContractService {
    private final ContractRepo repo;

    public ContractService(ContractRepo repo) {
        this.repo = repo;
    }   

//create
@Transactional
public ContractResponse create(ContractCreate response){
    // Example implementation: returning the input response
    repo.findByContractNumber(response.contractNumber()).ifPresent(c -> {
        throw new IllegalArgumentException("Contract with this number already exists");
    });

    Contract c = new Contract();
    c.setContractNumber(response.contractNumber());

    c.setStatus(response.status());
    c.setName(response.name());
    repo.save(c);
    return ContractResponse(c);
    
    
}


// Read by ID
@Transactional(readOnly = true)
public ContractResponse getById(Long id){
    Contract c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contract not found"));
    return ContractResponse(c);
}

@Transactional(readOnly = true)
public Page<ContractResponse> list(String status, int page, int size){
    var pageable = org.springframework.data.domain.PageRequest.of(page, size);
    Page<Contract> contracts = repo.findByStatus(status, pageable);
    return contracts.map(this::ContractResponse);
}

//update

@Transactional
public ContractResponse update(Long id, ContractResponse response){
    Contract c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contract not found"));
    c.setStatus(response.status());
    c.setName(response.name());
    repo.save(c);
    return ContractResponse(c);
}

//delete
@Transactional
public void delete(Long id){
    Contract c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contract not found"));
    repo.delete(c);
}


//mapper
private ContractResponse ContractResponse(Contract c){
    return new ContractResponse(
        c.getId(),
        c.getContractNumber(),
        null,
        null,
        c.getStatus(),
        c.getName()
    );

}

    
}
