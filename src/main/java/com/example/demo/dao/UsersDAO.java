package com.example.demo.dao;

import com.example.demo.dao.base.BaseDAO;
import com.example.demo.dao.interfaces.IUserRepository;
import com.example.demo.dao.interfaces.IUsersDAO;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Component
public class UsersDAO extends BaseDAO<Users> implements IUsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public void create(Users user) {

        StringBuilder stringBuilder = new StringBuilder();
        String sql = String.format("INSERT INTO users (name, age) VALUES ('%s','%s')", user.getName(), user.getAge());

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format("DELETE FROM users WHERE id =%s", id);

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted");
        }
    }

    @Override
    public List<Users> getAll() {

        // methode repository JPA
        List<Users> users = iUserRepository.getAllUser();

        /*  methode classique de requète

        String sql = "SELECT * FROM users";
        List<Users> usersList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Users.class));

         */
        return users;
    }

    @Override
    public Users getById(Integer id) {

        /*
        String sql = "SELECT * FROM users WHERE id= ?";
        return (Users) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Users.class));
         */

        return iUserRepository.getById(id);
    }


    @Override
    public void update(Users user, Integer id) {
        String sql = String.format("UPDATE users SET name = '%s' , age='%s', WHERE id = %s", user.getName(), user.getAge(), user.getId());

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been modify");
        }
    }
}
