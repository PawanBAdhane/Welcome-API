package com.nsm.WelcomeAPI.Service;

import com.nsm.WelcomeAPI.DAO.employeeDao;
import com.nsm.WelcomeAPI.Entity.EmployeeEntity;
import com.nsm.WelcomeAPI.Service.ServiceImpl.employeeSeviceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeService implements employeeSeviceIMPL {


    @Autowired
    public employeeDao empDAO;

    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {

    }
}
