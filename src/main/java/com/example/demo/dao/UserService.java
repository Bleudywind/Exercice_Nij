package com.example.demo.dao;

import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.getAllUser();
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<String> getRolesById(Integer id) {
        return userRepository.getRolesbyId(id);
    }
}
