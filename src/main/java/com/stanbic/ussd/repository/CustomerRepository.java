package com.stanbic.ussd.repository;

import com.stanbic.ussd.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bkariuki
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByPhone(String contact);
}
