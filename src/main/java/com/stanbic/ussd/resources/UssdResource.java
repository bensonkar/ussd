package com.stanbic.ussd.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UssdResource {
    @GetMapping("/")
    public String test() {
        return "<h1>Ussd app dev started</h1>";
    }
}
