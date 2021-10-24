package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AssignmentService {

    List<Assignment> getAllAssignment();

    Optional<Assignment> findById(String MaPC);

    Object save(Assignment newAssignment);

    boolean existsById(String MaPC);

    void deleteById(String MaPC);
}
