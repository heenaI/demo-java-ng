package com.example.demo.dto;

public record ContractResponse(
    Long id,
    String contractNumber,
    String startDate,
    String endDate,
    String status,
    String name
    ) {
}