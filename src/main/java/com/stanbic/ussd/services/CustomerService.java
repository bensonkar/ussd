package com.stanbic.ussd.services;

import com.stanbic.ussd.entities.Customer;
import com.stanbic.ussd.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bkariuki
 */
@Component
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException("unable to save customer  "+e.getMessage());
        }
    }
}
