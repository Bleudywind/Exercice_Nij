package com.example.demo.dao.interfaces;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    public List<User> getAllUser();

    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    public User getById(Integer id);

    @Query(value = "DELETE FROM user WHERE id =?1", nativeQuery = true)
    public void deleteById(Integer id);

    @Query(value ="SELECT name FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id = ?1)", nativeQuery = true)
    public List<String> getRolesbyId(Integer userid);

}
