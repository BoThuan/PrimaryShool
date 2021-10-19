package com.example.primaryschool.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tblClassroom")
public class Classroom {
    @Id
    private String MaLop;
    private String MaKhoi;
    private String MaGV;
    private String TenLop;
    private Date   Year;

}
