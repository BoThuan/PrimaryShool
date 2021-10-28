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
@Table(name = "tblAssignment")
public class Assignment implements Serializable {
    @Id
    private String MaPC;

    @Column(nullable = false, unique = false, length = 10)
    private String Ca;

    @Column(nullable = false, unique = false, length = 10)
    private String HocKy;

    @ManyToOne @JoinColumn(name = "MaLop") Classroom classroom;

    @ManyToOne @JoinColumn(name = "MaGV") Teachers teachers;

    @ManyToOne @JoinColumn(name = "MaMon") Subjects subjects;


    @JsonIgnore
    @OneToMany(mappedBy = "assignment")
    List<Results> results;
}