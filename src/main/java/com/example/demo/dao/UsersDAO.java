package com.example.demo.dao;

import com.example.demo.dao.base.BaseDAO;
import com.example.demo.dao.interfaces.IUsersDAO;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class UsersDAO extends BaseDAO<User> implements IUsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(User user) {

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
    public List<User> getAll() {

        String sql = "SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));

        return userList;
    }

    @Override
    public User getById(Integer id) {

        String sql = "SELECT * FROM users WHERE id= ?";
        return (User) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(User.class));
    }


    @Override
    public void update(User user, Integer id) {
        String sql = String.format("UPDATE users SET name = '%s' , age='%s', WHERE id = %s", user.getName(), user.getAge(), user.getId());

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been modify");
        }
    }
}
