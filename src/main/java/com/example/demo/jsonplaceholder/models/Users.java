package com.example.demo.jsonplaceholder.models;

import com.example.demo.models.base.EntityBase;

import javax.persistence.*;

@Entity
public class Users extends EntityBase {

    private String name;

    private String username;

    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String phone;

    private String website;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
