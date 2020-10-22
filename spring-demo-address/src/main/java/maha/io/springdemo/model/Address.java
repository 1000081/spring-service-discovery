package maha.io.springdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}
