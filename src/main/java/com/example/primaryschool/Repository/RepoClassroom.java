package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoClassroom extends JpaRepository<Classroom, String> {
}
