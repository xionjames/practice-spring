package com.xionjames.springmvcdemo1.services;

import java.util.List;

import com.xionjames.springmvcdemo1.domains.Customer;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Integer id);

    public Customer insertOrEdit(Customer customer);

    public void deleteCustomerById(Integer id);
}