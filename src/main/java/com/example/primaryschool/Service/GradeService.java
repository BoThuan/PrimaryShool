package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GradeService {

    List<Grade> getAllParents();

    Optional<Grade> findById(String MaKhoi);

    Object save(Grade newGrade);

    boolean existsById(String MaKhoi);

    void deleteById(String MaKhoi);
}
