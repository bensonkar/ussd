package com.stanbic.ussd.services;

import com.stanbic.ussd.entities.Customer;
import com.stanbic.ussd.repository.CustomerRepository;
import com.stanbic.ussd.wrappers.UssdRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author bkariuki
 */
@Service
public class UssdService {

    private static final Logger logger = LoggerFactory.getLogger(UssdService.class);
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public UssdService(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    public String handleUSSD(UssdRequest request) {
        StringBuilder response = new StringBuilder("");
        Customer customer = customerRepository.findByPhone(request.getPhoneNumber());

        if (Objects.nonNull(customer)) {
            response.append("END Customer is already registered \n" + "for support please call 0711068888");
        }

        if (request.getText().isEmpty() && customer == null) {
            response.append("CON Enter Head of office agent code");
        }
        String[] data = request.getText().split("\\*");
        if (!request.getText().isEmpty() && !request.getText().contains("*")) {
            response.append("CON Enter store number");
        }
        if (!request.getText().isEmpty() && data.length == 2) {
            response.append("CON Enter contact number to call");
        }
        if (!request.getText().isEmpty() && data.length == 3) {
            response.append("CON Allow Safaricom to share this information with Stanbic bank \n1: Yes \n2: No");
        }

        if (!request.getText().isEmpty() && data.length == 4) {
            int num = Integer.parseInt(data[3]);
            if (num == 2) {
                response.append("END Sorry you didnt accept terms and conditions");
            } else if (num > 2) {
                response.append("END Sorry you entered invalid input");
            } else {
                //TODO collect data from ussd
                String headOfOfficeCode = data[0];
                String storeNumber = data[1];
                String contactNumber = data[2];
                //TODO post data here to the database
                customer = new Customer();
                customer.setPhone(request.getPhoneNumber());
                customer.setHeadOfOfficeNumber(headOfOfficeCode);
                customer.setStoreNumber(storeNumber);
                customer.setContact(contactNumber);
                customerService.create(customer);

                response.append("END Thanks for creating an account with us");
            }
        }
        return response.toString();
    }

}
