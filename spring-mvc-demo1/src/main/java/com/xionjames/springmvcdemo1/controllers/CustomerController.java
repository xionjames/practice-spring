package com.xionjames.springmvcdemo1.controllers;

import com.xionjames.springmvcdemo1.domains.Customer;
import com.xionjames.springmvcdemo1.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public String index() {
        return "customer/index";
    }

    @RequestMapping("/customers")
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());

        return "customer/list";
    }

    @RequestMapping("/customer/{id}")
    public String getOne(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));

        return "customer/one";
    }

    @RequestMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String insertOrUpdate(Customer customer) {
        Customer savedCustomer = customerService.insertOrEdit(customer);

        return "redirect:/customer/" + savedCustomer.getId();
    }

    @RequestMapping("/customer/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "customer/form";
    }

    @RequestMapping("/customer/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        this.customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}