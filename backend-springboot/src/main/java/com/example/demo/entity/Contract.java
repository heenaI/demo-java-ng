package com.example.demo.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.Instant;

@Entity

public class Contract {
    @Column(unique = true, nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    private String contractType;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String contractNumber;

    @Column(nullable = false)
    private String createdAt = Instant.now().toString();


    private String updatedAt;

    @NotBlank
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    @NotBlank private String name;

    @NotBlank
    @Column(nullable = false)
    private String startDate;

    @NotBlank
    @Column(nullable = false)
    private String endDate;

    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContractType() {
        return contractType;
    }
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContractNumber() {
        return contractNumber;
    }   

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    
}
