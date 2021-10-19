package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAssignment extends JpaRepository<Assignment, String> {
}
