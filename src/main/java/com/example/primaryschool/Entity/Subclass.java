package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblSubclass")
public class Subclass implements Serializable {
    @Id
    private String MaPL;
    private String HanhKiem;
    private String XepLoai;
    private Double DiemTBNam;


    @ManyToOne @JoinColumn(name = "MaLop") Classroom classroom;


    @JsonIgnore
    @OneToMany(mappedBy = "subclass")
    List<Students> Students;

    @JsonIgnore
    @OneToMany(mappedBy = "subclass")
    List<Attendance> Attendance;

    @JsonIgnore
    @OneToMany(mappedBy = "subclass")
    List<Results> Results;

    @JsonIgnore
    @OneToMany(mappedBy = "subclass")
    List<License> License;
}
