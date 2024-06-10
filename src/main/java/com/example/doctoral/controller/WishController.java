package com.example.doctoral.controller;

import com.example.doctoral.entity.*;
import com.example.doctoral.service.RoleService;
import com.example.doctoral.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.List;

@RestController
@RequestMapping(path = "/wish")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WishController {
    private final WishService wishService;

    @PostMapping(path = "/create",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Wish createNewWish(@RequestPart("wish") Wish wish,
                              @RequestPart("file")MultipartFile[] files,
                              @RequestPart("file1")MultipartFile[] files1,
                              @RequestPart("file2")MultipartFile[] files2,
                              @RequestPart("file3")MultipartFile[] files3,
                              @RequestPart("file4")MultipartFile[] files4,
                              @RequestPart("file5")MultipartFile[] files5,
                              @RequestPart("file6")MultipartFile[] files6){
        try{
            Set<FileEntity> file = uploadFile(files);
            Set<FileEntity1> file1 = uploadFile1(files1);
            Set<FileEntity2> file2 = uploadFile2(files2);
            Set<FileEntity3> file3 = uploadFile3(files3);
            Set<FileEntity4> file4 = uploadFile4(files4);
            Set<FileEntity5> file5 = uploadFile5(files5);
            Set<FileEntity6> file6 = uploadFile6(files6);
            wish.setFiles(file);
            wish.setFiles1(file1);
            wish.setFiles2(file2);
            wish.setFiles3(file3);
            wish.setFiles4(file4);
            wish.setFiles5(file5);
            wish.setFiles6(file6);
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

    public Set<FileEntity1> uploadFile1(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity1> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity1 fileEntity=new FileEntity1(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }

    public Set<FileEntity2> uploadFile2(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity2> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity2 fileEntity=new FileEntity2(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }
    public Set<FileEntity3> uploadFile3(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity3> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity3 fileEntity=new FileEntity3(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }
    public Set<FileEntity4> uploadFile4(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity4> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity4 fileEntity=new FileEntity4(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }
    public Set<FileEntity5> uploadFile5(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity5> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity5 fileEntity=new FileEntity5(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }
    public Set<FileEntity6> uploadFile6(MultipartFile[] multipartFiles) throws IOException {
        Set<FileEntity6> fileModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileEntity6 fileEntity=new FileEntity6(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            fileModels.add(fileEntity);
        }
        return fileModels;
    }

    @GetMapping(path = "/get/{email}")
    public List<Wish> getByUser(@PathVariable String email){
        return wishService.getByUser(email);
    }

    @PutMapping(path = "/update/status/{email}")
    public String updateStatus(@PathVariable String email){
        return wishService.updateStatus(email);
    }

    @GetMapping(path = "/get/id/{id}")
    public Optional<Wish> getById(@PathVariable Integer id){
        return wishService.getById(id);
    }

    @GetMapping(path = "/get/all")
    public List<Wish> getAll(){
        return wishService.getAll();
    }
}
