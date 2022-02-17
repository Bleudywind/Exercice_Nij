package com.example.demo.models;

import com.example.demo.models.base.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends EntityBase {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    @ManyToMany(mappedBy = "users", targetEntity = Role.class)
    private List<Role> roles = new ArrayList<Role>();

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
