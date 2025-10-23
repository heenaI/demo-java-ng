package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateContractException extends RuntimeException {
    public DuplicateContractException(String message) {
        super(message);
    }
}