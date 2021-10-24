package com.example.primaryschool.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblClassroom")
public class Classroom {
    @Id
    private String MaLop;
    private String Khoi;
    private String MaGV;
    private String TenLop;
    private Date   Year;

}
