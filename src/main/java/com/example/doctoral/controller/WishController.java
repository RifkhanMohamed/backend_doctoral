package com.example.doctoral.controller;

import com.example.doctoral.entity.FileEntity;
import com.example.doctoral.entity.Role;
import com.example.doctoral.entity.Wish;
import com.example.doctoral.service.RoleService;
import com.example.doctoral.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/wish")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WishController {
    private final WishService wishService;

    @PostMapping(path = "/create",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Wish createNewRole(@RequestPart("wish") Wish wish, @RequestPart("file")MultipartFile[] files){
        try{
            Set<FileEntity> file = uploadFile(files);
            wish.setFiles(file);
            return wishService.createOrUpdateWish(wish);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<FileEntity> uploadFile(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity fileEntity=new FileEntity(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }
}
