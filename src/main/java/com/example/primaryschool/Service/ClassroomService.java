package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Classroom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClassroomService {
    List<Classroom> getAllClassroom();

    Optional<Classroom> findById(String MaLop);

    Object save(Classroom newClassroom);

    boolean existsById(String MaLop);

    void deleteById(String MaLop);
}
