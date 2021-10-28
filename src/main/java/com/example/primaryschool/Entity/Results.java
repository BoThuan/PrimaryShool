package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblResults")
public class Results implements Serializable {
    @Id
    private String MaKQ;
    private Double DiemKT;
    private Double DiemGiuak1;
    private Double DiemGiuak2;
    private Double DiemCuoik1;
    private Double DiemCuoik2;

    @ManyToOne @JoinColumn(name = "MaPC") Assignment assignment;

    @ManyToOne @JoinColumn(name = "MaPL") Subclass subclass;
}
