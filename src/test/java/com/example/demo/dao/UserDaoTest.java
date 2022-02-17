package com.example.demo.dao;

import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserDaoTest {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void getById() {
        User user = usersDAO.getById(1);
        System.out.println(user);
    }

    @Test
    public void check1() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
}
