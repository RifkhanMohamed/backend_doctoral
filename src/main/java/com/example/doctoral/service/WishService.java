package com.example.doctoral.service;

import com.example.doctoral.entity.Wish;
import com.example.doctoral.repo.WishRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishService {
    private final WishRepo wishRepo;

    public Wish createOrUpdateWish(Wish wish) {
        return wishRepo.save(wish);
    }
    public List<Wish> getByUser(String email){
        return wishRepo.findByUser(email);
    }
    public String updateStatus(String email) {
        int updatedRows = wishRepo.updateStatus(email);
        return updatedRows > 0 ? "Status updated successfully" : "No wishes found for the user";
    }
    public String updateStatusPreSelected(String email,String status) {
        int updatedRows = wishRepo.updateStatusPreSelected(email,status);
        return updatedRows > 0 ? "Status updated successfully" : "No wishes found for the user";
    }
    public Optional<Wish> getById(Integer id){
        return wishRepo.findById(id);
    }

    public List<Wish> getAll(){
        return wishRepo.findAll();
    }

    public List<Wish> getAllByStatus(String status){
        return wishRepo.findAllByStatus(status);
    }

    public List<Wish> getAllByStatusResults(){
        return wishRepo.findAllByStatusResults();
    }

    public List<Wish> getAllByStatusResultsStructureManager(){
        return wishRepo.findAllByStatusResultsStructureManager();
    }

    public List<Wish> getAllByStatusResultsDirector(){
        return wishRepo.findAllByStatusResultsDirector();
    }

    public List<Wish> getAllByStatusResultsLab(){
        return wishRepo.getAllByStatusResultsLab();
    }

    public List<Wish> getAllByStatusResultsDean(){
        return wishRepo.getAllByStatusResultsDean();
    }

}
