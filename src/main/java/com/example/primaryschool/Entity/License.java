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
@Table(name = "tblLicense")
public class License {
    @Id
    private String MaGP;
    private String MaPH;
    private Date Ngay;
    private Date BatDau;
    private Date KetThuc;
    private String LyDo;
    private Boolean Duyet;
}
