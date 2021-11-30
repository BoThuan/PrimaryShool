package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblStudents")
public class Students implements Serializable {
    @Id
    private String MaHS;
    private String TenHS;
    private Date NgaySinh;
    private Boolean GioiTinh;
    private String DiaChi;
    private String GhiChu;
    private String Hinh;
    private String SDTPhuHuynh;

    @ManyToOne @JoinColumn(name = "MaPH") Parents parents;

    @ManyToOne @JoinColumn(name = "MaPL") Subclass subclass;

    @JsonIgnore
    @OneToMany(mappedBy = "students")
    List<Results> results;
}
