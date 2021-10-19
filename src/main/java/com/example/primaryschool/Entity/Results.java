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
@Table(name = "tblResults")
public class Results {
    @Id
    private String MaKQ;
    private String MaPL;
    private String MaPC;
    private Double DiemMieng;
    private Double Diem15p;
    private Double Diem1t;
}
