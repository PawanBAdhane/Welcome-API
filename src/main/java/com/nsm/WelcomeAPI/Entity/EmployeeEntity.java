package com.nsm.WelcomeAPI.Entity;

import jdk.nashorn.internal.objects.annotations.Setter;

@Setter
public class EmployeeEntity {

    private long EmpId;
    private String EmpName;
    private String EmpContact;

    public long getEmpId() {
        return EmpId;
    }

    public void setEmpId(long empId) {
        EmpId = empId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpContact() {
        return EmpContact;
    }

    public void setEmpContact(String empContact) {
        EmpContact = empContact;
    }
}
