package com.example.demo.dao;

import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.PostConstruct;
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
        Users user = usersDAO.getById(1);
        System.out.println(user);
    }

    @Test
    public void check1() {
        List<Users> users = userRepository.findAll();
        System.out.println(users);
    }
}
