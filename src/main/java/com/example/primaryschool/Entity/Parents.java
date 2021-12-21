package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblParents")
public class Parents implements Serializable {
    @Id
    private String MaPH;
    private String TenPH;
    private String QuanHe;
    private String GhiChu;
    private String Hinh;

    @JsonIgnore
    @OneToMany(mappedBy = "parents")
    List<Students> Students;

    @JsonIgnore
    @OneToMany(mappedBy = "parents")
    List<License> License;
}
