package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblApprove")
public class Approve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maPD;
    private String nguoiGui;
    private String thoiGian;
    private String noiDung;
    private Boolean pheDuyet;
}
