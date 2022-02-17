package com.example.demo.dao.interfaces;

import com.example.demo.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    public List<Users> getAllUser();

    @Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
    public Users getById(Integer id);

    @Query(value = "DELETE FROM users WHERE id =?1", nativeQuery = true)
    public void deleteById(Integer id);

}
