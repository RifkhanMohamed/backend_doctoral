package com.example.doctoral.repo;

import com.example.doctoral.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishRepo extends JpaRepository<Wish,Integer> {
}
