package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblTeachers")
public class Teachers implements Serializable {
    @Id
    private String MaGV;
    private String TenGV;
    private Date NgaySinh;
    private Boolean GioiTinh;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String GhiChu;

    @JsonIgnore
    @OneToMany(mappedBy = "teachers")
    List<Assignment> Assignment;

    @JsonIgnore
    @OneToMany(mappedBy = "teachers")
    List<Classroom> Classroom;


}
