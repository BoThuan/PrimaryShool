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
@Table(name = "tblParents")
public class Parents {
    @Id
    private String MaPH;
    private String TenPH;
    private String Sdt;
    private String QuanHe;
    private String GhiChu;
}
