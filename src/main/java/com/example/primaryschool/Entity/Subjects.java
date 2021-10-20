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
@Table(name = "tblSubjects")
public class Subjects {
    @Id
    private String MaMon;
    @Column(nullable = false, unique = true, length =300)
    private String TenMon;
}
