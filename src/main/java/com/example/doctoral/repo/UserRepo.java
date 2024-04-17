package com.example.doctoral.repo;

import com.example.doctoral.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select full_name from user where user_name=?1", nativeQuery = true)
    String findByUsername(String username);
}
