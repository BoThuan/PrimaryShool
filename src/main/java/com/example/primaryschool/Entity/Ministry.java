package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

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
    private Integer SDT;
    private String Email;
    private String DiaChi;
    private String GhiChu;
}
