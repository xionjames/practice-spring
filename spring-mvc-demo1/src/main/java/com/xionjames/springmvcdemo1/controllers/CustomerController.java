package com.xionjames.springmvcdemo1.controllers;

import com.xionjames.springmvcdemo1.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "customer/index";
    }

    @RequestMapping(path = "/customers")
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());

        return "customer/list";
    }

    @RequestMapping(path = "/customer/{id}")
    public String getOne(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));

        return "customer/one";
    }
}