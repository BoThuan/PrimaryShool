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
@Table(name = "tblClassroom")
public class Classroom implements Serializable {
    @Id
    private String MaLop;
    private String Khoi;
    private String TenLop;
    private String Year;
    private String hinh;

    @ManyToOne @JoinColumn(name = "MaGiaoVu")
    Ministry ministry;

    @ManyToOne @JoinColumn(name = "MaGV")
    Teachers teachers;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    List<Subclass> subclasses;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    List<Assignment> Assignment;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    List<Attendance> Attendance;
}


