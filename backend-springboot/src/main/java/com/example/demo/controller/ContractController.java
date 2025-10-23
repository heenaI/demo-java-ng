package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ContractService; // Import the ContractService class

import jakarta.validation.Valid;

import com.example.demo.dto.ContractCreate;
import com.example.demo.dto.ContractResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;




@RestController
@RequestMapping("/api/contracts")

public class ContractController {
    private final ContractService service;
    public ContractController(ContractService service) {
        this.service = service;
    }

@PostMapping("/create")
public ContractResponse postContract(@RequestBody @Valid ContractCreate req) {
    return service.create(req);
}

@PutMapping("update/{id}")
public ContractResponse putContract(@PathVariable Long id, @Valid @RequestBody ContractResponse res) {
    return service.update(id, res);
}

@DeleteMapping("/delete/{id}")
public void deleteContract(@PathVariable Long id) {
    service.delete(id);
}

@GetMapping("/getById/{id}")
public ContractResponse getContractById(@PathVariable Long id) {
    return service.getById(id);
}

@GetMapping("path")
public Page<ContractResponse> listContracts(
    @RequestParam(required = false) String status,
    @RequestParam(defaultValue ="0") int page,
    @RequestParam(defaultValue ="20") int size) {
    return service.list(status, page, size);

    }

}
