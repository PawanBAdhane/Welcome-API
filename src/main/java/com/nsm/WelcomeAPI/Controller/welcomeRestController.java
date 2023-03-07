package com.nsm.WelcomeAPI.Controller;

import com.nsm.WelcomeAPI.Entity.EmployeeEntity;
import com.nsm.WelcomeAPI.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeRestController {


    @Autowired
    public employeeService empservice;

    @GetMapping("/welcome")
    public String welcomemsg() {
        String msg = "Welcome to microservice demo";

        return msg;
    }

   /* @GetMapping(value = "/employee")
    public void employeeInfo(EmployeeEntity employeeEntity) {
        empservice.saveEmployee(employeeEntity);

    }*/
}
