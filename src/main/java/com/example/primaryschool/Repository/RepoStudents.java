package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoStudents extends JpaRepository<Students, String> {
}
