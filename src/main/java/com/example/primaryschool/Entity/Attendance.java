package com.example.primaryschool.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblAttendance")
public class Attendance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MaDD;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "Ngay")
    private Date Ngay;
    private Boolean Co;

    @ManyToOne @JoinColumn(name = "MaPL") Subclass subclass;

    @ManyToOne @JoinColumn(name = "MaLop") Classroom classroom;
}
