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
@Table(name = "tblGrade")
public class Grade {
    @Id
    private String MaKhoi;
    private String TenKhoi;
}
