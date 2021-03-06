package com.xionjames.springmvcdemo1.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.xionjames.springmvcdemo1.domains.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private HashMap<Integer, Customer> customers = null;

    @Override
    public List<Customer> getAllCustomers() {
        if (this.customers == null) {
            this.customers = new HashMap<>();
            
            Customer customer = new Customer();
            customer.setId(1);
            customer.setFirstName("John");
            customer.setLastName("Doe");
            customer.setEmail("john.doe@domain.com");
            customer.setPhoneNumber("+1 123 555 3331");
            customer.setCity("New York");
            customer.setState("New York");
            customer.setAddressLine1("Kr 7 # 123");
            customer.setAddressLine2("");
            customer.setZipCode("111222");

            this.customers.put(customer.getId(), customer);

            customer = new Customer();
            customer.setId(2);
            customer.setFirstName("Ed");
            customer.setLastName("Monton");
            customer.setEmail("ed.monton@domain.com");
            customer.setPhoneNumber("+1 999 999 9999");
            customer.setCity("Edmonton");
            customer.setState("Alberta");
            customer.setAddressLine1("4 St 44112");
            customer.setAddressLine2("12345");
            customer.setZipCode("999888");

            this.customers.put(customer.getId(), customer);
        }
        return this.customers
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getValue())
                    .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return this.customers.get(id);
    }

    @Override
    public Customer insertOrEdit(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("Customer cannot be null.");
        } 
        if (customer.getId() == null) {
            customer.setId(getNextSequence());
        }

        this.customers.put(customer.getId(), customer);
        return customer;
    }

    private Integer getNextSequence() {
        return Collections.max(this.customers.keySet()) + 1;
    }

    @Override
    public void deleteCustomerById(Integer id) {
        this.customers.remove(id);
    }
}