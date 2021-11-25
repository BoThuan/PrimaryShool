package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblMinistry")
public class Ministry {
    @Id
    private String MaGiaoVu;
    private String TenGiaoVu;
    private String ChucVu;
    private String SDT;
    private String Email;
    private Boolean GioiTinh;
    private Date NgaySinh;
    private String DiaChi;
    private String GhiChu;
    private String Hinh;

    @JsonIgnore
    @OneToMany(mappedBy = "ministry")
    List<Classroom> Classrooms;
}
