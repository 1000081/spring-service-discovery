package maha.io.springdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
public class Address {

    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name="ADDRESS_LINE_1")
    private String addressLine1;

    @Column(name="ADDRESS_LINE_2")
    private String addressLine2;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP")
    private String zip;
}
