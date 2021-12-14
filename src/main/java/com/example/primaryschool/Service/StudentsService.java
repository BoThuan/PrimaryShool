package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Students;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentsService {

    List<Students> getAllStudents();

    Optional<Students> findById(String MaHS);

    Optional<Students> findByName(String Name);

    Optional<Students> findBySDT(String SDT);

    Optional<Students> findByMale(Boolean GioiTinh);

    Integer countStudent();

    Integer countStudentkhoi(String khoi);

    Object save(Students newStudents);

    boolean existsById(String MaHS);

    void deleteById(String MaHS);

}
