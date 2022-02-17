package com.example.demo.models;

import com.example.demo.models.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends EntityBase {

    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> users = new ArrayList<UserRole>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole> getUsers() {
        return users;
    }

    public void setUsers(List<UserRole> users) {
        this.users = users;
    }
}
