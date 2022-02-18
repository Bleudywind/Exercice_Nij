package com.example.demo.jsonplaceholder.controler;

import com.example.demo.jsonplaceholder.models.Users;
import com.example.demo.jsonplaceholder.service.UsersServiceRT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UsersControlerRT {

    @Autowired
    private UsersServiceRT usersServiceRT;

    @GetMapping
    public List<Users> getAll() {
        List<Users> usersList = usersServiceRT.getAll();
        return usersList;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        String users = usersServiceRT.getById(id);
        return users;
    }

    @PostMapping
    public String create (@RequestBody Users user) {
        return usersServiceRT.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        usersServiceRT.delete(id);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Users user, @PathVariable Integer id) {
        return usersServiceRT.update(user, id);
    }
}
