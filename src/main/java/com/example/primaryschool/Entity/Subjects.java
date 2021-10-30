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
@Table(name = "tblSubjects")
public class Subjects implements Serializable {
    @Id
    private String MaMon;
    @Column(nullable = false, unique = true, length =300)
    private String TenMon;

    @JsonIgnore
    @OneToMany(mappedBy = "subjects")
    List<Assignment> Assignment;
}
