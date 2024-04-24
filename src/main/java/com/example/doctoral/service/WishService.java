package com.example.doctoral.service;

import com.example.doctoral.entity.Wish;
import com.example.doctoral.repo.WishRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishService {
    private final WishRepo wishRepo;

    public Wish createOrUpdateWish(Wish wish) {
        return wishRepo.save(wish);
    }
}
