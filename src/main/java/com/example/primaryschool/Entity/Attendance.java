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
@Table(name = "tblAttendance")
public class Attendance {
    @Id
    private Integer MaDD;
    private String MaLop;
    private String MaPL;
    private Date Ngay;
    private Boolean Co;
}
