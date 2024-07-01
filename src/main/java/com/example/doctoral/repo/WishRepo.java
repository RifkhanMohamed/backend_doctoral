package com.example.doctoral.repo;

import com.example.doctoral.entity.User;
import com.example.doctoral.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WishRepo extends JpaRepository<Wish,Integer> {
    @Query(value = "select * from wish where status=?1", nativeQuery = true)
    List<Wish> findAllByStatus(String status);
    @Query(value = "select * from wish where status='pass' or status='fail' or status='thesis_director_validated' or status='thesis_director_rejected'", nativeQuery = true)
    List<Wish> findAllByStatusResults();
    @Query(value = "select * from wish where status='thesis_director_validated' or status='thesis_director_rejected' or status='structure_manager_confirmed' or status='structure_manager_rejected'", nativeQuery = true)
    List<Wish> findAllByStatusResultsStructureManager();
    @Query(value = "select * from wish where user=?1", nativeQuery = true)
    List<Wish> findByUser(String email);
    @Modifying
    @Transactional
    @Query(value = "update wish set status='applied' where user=?1", nativeQuery = true)
    int updateStatus(String email);
    @Modifying
    @Transactional
    @Query(value = "update wish set status=?2 where user=?1", nativeQuery = true)
    int updateStatusPreSelected(String email,String status);
}
