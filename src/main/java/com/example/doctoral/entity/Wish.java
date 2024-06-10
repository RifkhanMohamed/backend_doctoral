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
    @JoinTable(name = "wish_files_diplomas",
            joinColumns = {
            @JoinColumn(name = "wish_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity> files;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_certified_diplomas",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity1> files1;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_transcripts",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity2> files2;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_photos",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity3> files3;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_birth_certificate",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity4> files4;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_id_card",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity5> files5;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "wish_files_thesis",
            joinColumns = {
                    @JoinColumn(name = "wish_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "file_id")
            }
    )
    private Set<FileEntity6> files6;
    private String user;
    private String status;
    private String establishment;
    private String department;
    private String center;
    private String head;
    private String structure;
    private String headstructure;
    private String supervisor;
    private String siga;
    private String apogee;
    private String dob;
    private String place;
    private String cr;
    private String nationality;
    private String address;
    private String degree;
    private String qdegree;
    private String qdegreeother;
    private String thesissubject;
    private String cosupervisor;
    private String addresscosupervisor;
    private String cosupervisorphone;
    private String cosupervisoremail;
    private String cosupervision;
    private String marital;
    private String gender;
    private String salstatus;
    private String bspeciality;
    private String byear;
    private String bestablishment;
    private String lspeciality;
    private String lyear;
    private String lestablishment;
    private String mspeciality;
    private String myear;
    private String mestablishment;
    private String ospeciality;
    private String oyear;
    private String oestablishment;
    private String lang1;
    private String lang2;
    private String lang3;
    private String lang4;
    private String lang1reading;
    private String lang1writing;
    private String lang1spoken;
    private String lang2reading;
    private String lang2writing;
    private String lang2spoken;
    private String lang3reading;
    private String lang3writing;
    private String lang3spoken;
    private String lang4reading;
    private String lang4writing;
    private String lang4spoken;
    private String r1name;
    private String r1title;
    @Column(columnDefinition = "TEXT")
    private String r1address;
    @Column(columnDefinition = "TEXT")
    private String r2name;
    @Column(columnDefinition = "TEXT")
    private String r2title;
    @Column(columnDefinition = "TEXT")
    private String r2address;
    @Column(columnDefinition = "TEXT")
    private String r3name;
    @Column(columnDefinition = "TEXT")
    private String r3title;
    @Column(columnDefinition = "TEXT")
    private String r3address;
    @Column(columnDefinition = "TEXT")
    private String otherestablishments;
    @Column(columnDefinition = "TEXT")
    private String otherestablishmentsyear;
    @Column(columnDefinition = "TEXT")
    private String applicationrefused;
    @Column(columnDefinition = "TEXT")
    private String applicationrefusedreason;
}
