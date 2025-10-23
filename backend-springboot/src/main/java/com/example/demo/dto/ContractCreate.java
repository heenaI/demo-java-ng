package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContractCreate(
    @NotBlank @Size(max=50) String contractNumber,
    @NotBlank String startDate,
    String endDate,
    @NotBlank @Size(max = 30) String status,
    @NotBlank String name
) {
}