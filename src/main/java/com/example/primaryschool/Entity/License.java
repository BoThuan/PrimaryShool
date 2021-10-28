package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblLicense")
public class License implements Serializable {
    @Id
    private String MaGP;
    private Date Ngay;
    private Date BatDau;
    private Date KetThuc;
    private String LyDo;
    private Boolean Duyet;

    @ManyToOne @JoinColumn(name = "MaPL") Subclass subclass;

    @ManyToOne @JoinColumn(name = "MaPH") Parents parents;
}
