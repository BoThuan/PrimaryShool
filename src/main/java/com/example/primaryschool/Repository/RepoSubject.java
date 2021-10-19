package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoSubject extends JpaRepository<Subjects, String> {
}
