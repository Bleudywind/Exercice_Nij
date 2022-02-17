package com.example.demo.dao.interfaces.base;

import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract interface IBaseDAO<T> {

    public void delete(Integer id);
    public List<T> getAll();
    public T getById(Integer id);
    public void update (T item, Integer id);
    public void create (T item);
}
