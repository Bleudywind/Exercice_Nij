package com.example.demo.dao.base;

import com.example.demo.dao.interfaces.base.IBaseDAO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public abstract class BaseDAO<T> implements IBaseDAO<T>{

    //default function to implement

    @PersistenceContext
    protected EntityManager entityManager;
}
