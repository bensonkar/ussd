package com.stanbic.ussd.resources;

import com.stanbic.ussd.entities.Customer;
import com.stanbic.ussd.services.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ussd")
public class UssdResource {

    private final CustomerService customerService;

    public UssdResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public void test() {
        System.out.println("ussd exposed public");
    }

    @PostMapping("/create")
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }

}
