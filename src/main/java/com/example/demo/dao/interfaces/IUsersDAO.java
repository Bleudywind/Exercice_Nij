package com.example.demo.dao.interfaces;

import com.example.demo.dao.interfaces.base.IBaseDAO;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsersDAO extends IBaseDAO<User> {

    public void update (User user, Integer id);
    public void create (User user);
    public List<User> getAll();
}
