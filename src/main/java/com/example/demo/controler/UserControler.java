package com.example.demo.controler;

import com.example.demo.dao.UserService;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    private UserService userService;


    @PostMapping
    public void create(@RequestBody Users user) {
        userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping
    public List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById (@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Users user) {
        userService.update(user);
    }
}
