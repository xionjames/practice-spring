package com.xionjames.springmvcdemo1.services;

import java.util.List;

import com.xionjames.springmvcdemo1.domains.Customer;

public interface CustomerService {
    List<Customer> listAllCustomers();
}