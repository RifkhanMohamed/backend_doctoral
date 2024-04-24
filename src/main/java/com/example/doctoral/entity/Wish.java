package com.example.doctoral.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "wish")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "course", nullable = false)
    private Course course;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files",
            joinColumns = {
            @JoinColumn(name = "wish_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity> files;
    @Convert(converter = StringListConverter.class)
    private List<String> qualification;
    private String user;
}
