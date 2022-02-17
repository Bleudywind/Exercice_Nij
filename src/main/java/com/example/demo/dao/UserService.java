package com.example.demo.dao;

import com.example.demo.dao.base.BaseDAO;
import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void create(Users user) {
        userRepository.save(user);
    }

    public List<Users> getAll() {
        return userRepository.getAllUser();
    }

    public Users getById(Integer id) {
        return userRepository.getById(id);
    }

    public void update(Users user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
