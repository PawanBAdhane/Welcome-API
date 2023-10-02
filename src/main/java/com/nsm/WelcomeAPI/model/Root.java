package com.nsm.WelcomeAPI.model;

import javax.persistence.*;

@Entity(name = "EmployeeDetails")
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String empid;
    @ManyToOne
    @JoinColumn(name = "personal_id")
    public Personal personal;
    public Profile profile;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
