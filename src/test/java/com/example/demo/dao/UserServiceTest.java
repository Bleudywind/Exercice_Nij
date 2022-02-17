package com.example.demo.dao;

import com.example.demo.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void create() {
        Users user = new Users();
        user.setId(3);
        user.setAge(18);
        user.setName("PatateTest");

        userService.create(user);
        System.out.println("\nNew User:");
        System.out.println(user.getName());
    }

    @Test
    public void getById() {
        Users user = userService.getById(2);
        System.out.println("\nGetting by id:");
        System.out.println(user.getName());
    }

    @Test
    public void update (){
        Users user = new Users();
        user.setId(2);
        user.setAge(20);
        user.setName("PatateTestModify");

        userService.update(user);
        System.out.println("\nUser modified:");
        System.out.println(user.getName());
    }

    @Test
    public void getAll(){
        List<Users> users = userService.getAll();
        System.out.println("\nGetting all:");
        System.out.println(users);
    }

    @Test
    public void delete(){
        Users user = new Users();
        user.setId(1);
        user.setAge(10);
        user.setName("test1");

        userService.delete(user);
        System.out.println("\nUser deleted");
    }
}
