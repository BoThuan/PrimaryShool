package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblTeachers")
public class Teachers {
    @Id
    private String MaGV;
    private String TenGV;
    private Date NgaySinh;
    private Boolean GioiTinh;
    private String DiaChi;
    private Integer SDT;
    private String Email;
    private String GhiChu;
}
