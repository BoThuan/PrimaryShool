package com.example.primaryschool.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tblAssignment")
public class Assignment {
    @Id
    private String MaPC;
    private String MaMon;
    private String MaLop;
    private String MaGV;
    private String Ca;
}
