package com.example.demo.models;

import com.example.demo.models.base.EntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends EntityBase {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<UserRole> roles = new ArrayList<UserRole>();

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
