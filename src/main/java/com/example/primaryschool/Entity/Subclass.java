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
@Table(name = "tblSubclass")
public class Subclass {
    @Id
    private String MaPL;
    private String MaLop;
    private String MaHS;
    private String HanhKiem;
    private String XepLoai;
    private Double DiemTBNam;
    private Double DiemKy1;
    private Double DiemKy2;
}
