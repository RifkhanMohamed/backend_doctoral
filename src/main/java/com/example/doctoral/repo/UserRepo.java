package com.example.doctoral.repo;

import com.example.doctoral.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select * from user where email=?1", nativeQuery = true)
    User findByEmail(String email);
    @Query(value = "SELECT COUNT(*) FROM `user_role` INNER JOIN `user` ON user_role.user_id = user.email where user_role.role_id='user'", nativeQuery = true)
    Number findAllUserCount();
    @Query(value = "SELECT COUNT(*) FROM `wish` WHERE status='applied'", nativeQuery = true)
    Number findAllPreUserCount();
    @Query(value = "SELECT COUNT(*) FROM `wish` WHERE status='pre_selected'", nativeQuery = true)
    Number findAllPreSelectedUserCount();
    @Query(value = "SELECT COUNT(*) FROM `wish` WHERE status=?1", nativeQuery = true)
    Number findAllStatusCount(String status);
    @Query(value = "SELECT * FROM `user_role` INNER JOIN `user` ON user_role.user_id = user.email where user_role.role_id='user'", nativeQuery = true)
    List<User> findAllUser();
}
