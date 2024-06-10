package com.example.doctoral.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "file_photos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] data;

    public FileEntity3(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}

