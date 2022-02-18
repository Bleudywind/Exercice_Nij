package com.example.demo.controler;

import com.example.demo.dao.UserService;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserService userService;


    @PostMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById (@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping("/{id}/roles")
    public List<String> getRoles(@PathVariable Integer id) {
        return userService.getRolesById(id);
    }
}
