package com.example.customer_service.responses;

import lombok.Data;

import java.util.List;

@Data
public class CustomerListResponse {
    private List<CustomerResponse> customers;
}
