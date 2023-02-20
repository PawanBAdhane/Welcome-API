package com.nsm.WelcomeAPI.Controller;

import com.nsm.WelcomeAPI.Entity.EmployeeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeRestController {

    @GetMapping("/welcome")
    public String welcomemsg() {
        String msg = "Welcome to microservice demo";

        return msg;
    }

    @GetMapping(value = "/employee")
    public void employeeInfo(EmployeeEntity employeeEntity) {


    }
}
