package com.example.customer_service.responses;

import com.example.customer_service.models.CustomerStatus;
import com.example.customer_service.models.KycStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerResponse {
    private String cifCode;
    private String fullName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private CustomerStatus status;
    private KycStatus kycStatus;
}
