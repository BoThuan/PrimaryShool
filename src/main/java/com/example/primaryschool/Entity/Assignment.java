package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
