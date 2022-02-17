package com.example.demo.controler;

import com.example.demo.dao.UsersDAO;
import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    private UsersDAO usersDAO;


    @PostMapping
    public void create(@RequestBody Users user) {
        usersDAO.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        usersDAO.delete(id);
    }

    @GetMapping
    public List<Users> getAll() {
        return usersDAO.getAll();
    }

    @GetMapping("/{id}")
    public Users getById (@PathVariable Integer id) {
        return usersDAO.getById(id);
    }

    @PutMapping
    public void update(@RequestBody Users user, @PathVariable Integer id) {
        usersDAO.update(user, id);
    }
}
