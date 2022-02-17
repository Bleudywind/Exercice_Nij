package com.example.demo.dao.interfaces;

import com.example.demo.dao.interfaces.base.IBaseDAO;
import com.example.demo.models.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsersDAO extends IBaseDAO<Users> {

    public void update (Users user, Integer id);
    public void create (Users user);
    public List<Users> getAll();
}
