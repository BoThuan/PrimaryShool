package com.example.primaryschool.Repository;

import com.example.primaryschool.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAttendance extends JpaRepository<Attendance, Integer> {
}
