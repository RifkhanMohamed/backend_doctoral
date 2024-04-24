package com.example.doctoral.repo;

import com.example.doctoral.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select * from user where email=?1", nativeQuery = true)
    User findByEmail(String email);
}
