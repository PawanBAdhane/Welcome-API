package com.nsm.WelcomeAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Setter
@Getter
@ToString
@Entity(name = "Address")
public class Address {
    public String streetaddress;
    public String city;
    public String state;
    public String postalcode;
}
