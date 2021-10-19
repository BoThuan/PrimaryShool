package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoGrade extends JpaRepository<Grade, String> {
}
