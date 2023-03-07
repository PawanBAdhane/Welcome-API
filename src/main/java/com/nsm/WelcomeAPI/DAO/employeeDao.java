package com.nsm.WelcomeAPI.DAO;

import com.nsm.WelcomeAPI.DAO.DAOImpl.employeeDaoImpl;
import com.nsm.WelcomeAPI.Entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class employeeDao implements employeeDaoImpl {
    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {

    }
}
