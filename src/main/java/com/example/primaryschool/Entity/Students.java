package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblStudents")
public class Students {
    @Id
    private String MaHS;
    private String TenHS;
    private Date NgaySinh;
    private Boolean GioiTinh;
    private String DiaChi;
    private String GhiChu;
    private String MaPH;
}
