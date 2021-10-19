package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoTeachers extends JpaRepository<Teachers, String> {
}
