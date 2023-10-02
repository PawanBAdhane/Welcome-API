package com.nsm.WelcomeAPI.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@Entity(name = "Personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String name;
    public String gender;
    public int age;
    public Address address;
}
