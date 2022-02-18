package com.example.demo.jsonplaceholder.service;

import com.example.demo.jsonplaceholder.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUsersRepository extends JpaRepository<Users, Long> {
}
