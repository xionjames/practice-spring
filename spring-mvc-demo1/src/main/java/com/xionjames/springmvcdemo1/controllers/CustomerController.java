package com.xionjames.springmvcdemo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @RequestMapping(path = "/")
    public String index() {
        return "customer/index";
    }
}