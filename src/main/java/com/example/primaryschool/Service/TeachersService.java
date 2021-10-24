package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Teachers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeachersService {

    List<Teachers> getAllTeachers();

    Optional<Teachers> findById(String MaGV);

    Object save(Teachers newTeachers);

    boolean existsById(String MaGV);

    void deleteById(String MaGV);
}
