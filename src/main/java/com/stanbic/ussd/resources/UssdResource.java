package com.stanbic.ussd.resources;

import com.stanbic.ussd.services.CustomerService;
import com.stanbic.ussd.services.UssdService;
import com.stanbic.ussd.wrappers.UssdRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author bkariuki
 */
@RestController
@RequestMapping("/ussd")
public class UssdResource {

    private final UssdService ussdService;

    public UssdResource(UssdService ussdService) {
        this.ussdService = ussdService;
    }

    @PostMapping(value = "/create", consumes = "application/x-www-form-urlencoded")
    public String create(UssdRequest request) {
        return ussdService.handleUSSD(request);
    }

}
